package restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import secondary.SecondaryMongoBean;
import secondary.SecondaryMongoBeanRepository;

@Service
public class DecrypterService {

    @Autowired
    private SecondaryMongoBeanRepository secondaryRepository;

    public Boolean start() {
        final String uri = "http://container2:8080/address-book/AddressEntry/getAll";
        RestTemplate restTemplate = new RestTemplate(); 
        String result = restTemplate.getForObject( uri, String.class);
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
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       return true;
    }
    
    public Integer stop() {
        List<SecondaryMongoBean> list = this.secondaryRepository.findAll();
        return list.size();
    }


}
