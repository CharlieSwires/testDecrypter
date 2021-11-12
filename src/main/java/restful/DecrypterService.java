package restful;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import secondary.SecondaryMongoBean;
import secondary.SecondaryMongoBeanRepository;

@Service
public class DecrypterService {

    @Autowired
    private SecondaryMongoBeanRepository secondaryRepository;
    private static final int NUM_THREADS = 10;
    private Boolean finished = false;

    public Boolean start() {
        final String uri = "http://container2:8080/address-book/AddressEntry/getAllArray";
        RestTemplate restTemplate = new RestTemplate();
        int page = 0;
        while(!finished) {
            List<Integer> pageThreads = new ArrayList<Integer>();
            for(int i=0; i< NUM_THREADS; i++) {
                pageThreads.add(page+i);
            }
            Stream<Boolean> temp  =pageThreads.parallelStream().map((i) -> {
                String result = restTemplate.getForObject( uri+"/"+(i), String.class);
                return (storeBatch(result));
            });
            if (!finished) finished = temp.allMatch((b) -> b == true);
            page += NUM_THREADS;
        }
        return true;
    }

    private Boolean storeBatch(String result) {
        ObjectMapper m = new ObjectMapper();
        ResponseBean1[] products = null;
        try {
            products = m.readValue(result, ResponseBean1[].class);
            for (ResponseBean1 item : products) {
                secondary.SecondaryMongoBean newItem = new SecondaryMongoBean();
                newItem.setAddress(item.getAddress());
                newItem.setFirstname(item.getFirstname());
                newItem.setHomeTel(item.getHomeTel());
                newItem.setMobile(item.getMobile());
                newItem.setPersonalEmail(item.getPersonalEmail());
                newItem.setSurname(item.getSurname());
                newItem.setTitle(item.getTitle());
                newItem.setWorkEmail(item.getWorkEmail());
                newItem.setWorkTel(item.getWorkTel());
                this.secondaryRepository.save(newItem);
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }
    public Long stop() {
        finished = true;
        return this.secondaryRepository.count();
    }


}
