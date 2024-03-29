package restful;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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
    private AtomicBoolean finished = new AtomicBoolean(false);
    static {
    	System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
    }

    public Boolean start() {
        final String uri = "http://container2:8080/address-book/AddressEntry/getAllArray";
        RestTemplate restTemplate = new RestTemplate();
        int page = 0;
        finished.set(false);
        while(!finished.get()) {
            List<Integer> pageThreads = new ArrayList<Integer>();
            for(int i=0; i< NUM_THREADS; i++) {
                pageThreads.add(page+i);
            }
            Stream<Boolean> temp  =pageThreads.parallelStream().map((i) -> {
                String result = restTemplate.getForObject( uri+"/"+(i), String.class);
                return (storeBatch(result));
            });
            finished.compareAndSet(false, !temp.anyMatch((b) -> b == false));
            page += NUM_THREADS;
        }
        return true;
    }

    private Boolean storeBatch(String result) {
        ObjectMapper m = new ObjectMapper();
        ResponseBean2[] products = null;
        if (result != null && !result.isEmpty()) {

            try {
                products = m.readValue(result, ResponseBean2[].class);
                if (products == null || products.length == 0) return true;

                for (ResponseBean2 item : products) {
                    if (item != null) {
                        SecondaryMongoBean newItem = new SecondaryMongoBean();
                        newItem.setId(item.getId());
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
                }
            } catch (Exception e) {
                return true;
            }
            return false;
        }
        return true;
    }
    private Boolean verifyBatch(String result) {
        ObjectMapper m = new ObjectMapper();
        ResponseBean2[] products = null;
        if (result != null && !result.isEmpty()) {
            try {
                products = m.readValue(result, ResponseBean2[].class);
                if (products == null || products.length == 0) return true;
                for (ResponseBean2 item : products) {
                    if (item == null) return true;
                    Optional<SecondaryMongoBean> newItem2 = secondaryRepository.findById(item.getId());
                    SecondaryMongoBean newItem = (newItem2.isPresent()) ? newItem2.get() : null;
                    if (newItem == null) return null;
                    ResponseBean2 newResponseBean = new ResponseBean2();
                    newResponseBean.setId(newItem.getId());
                    newResponseBean.setAddress(newItem.getAddress());
                    newResponseBean.setFirstname(newItem.getFirstname());
                    newResponseBean.setHomeTel(newItem.getHomeTel());
                    newResponseBean.setMobile(newItem.getMobile());
                    newResponseBean.setPersonalEmail(newItem.getPersonalEmail());
                    newResponseBean.setSurname(newItem.getSurname());
                    newResponseBean.setTitle(newItem.getTitle());
                    newResponseBean.setWorkEmail(newItem.getWorkEmail());
                    newResponseBean.setWorkTel(newItem.getWorkTel());
                    if (!newResponseBean.equals(item)) return null;
                }
            } catch (IncorrectResultSizeDataAccessException ex) {
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return false;
        }
        return true;
    }
    public Long stop() {
        finished.set(true);
        return this.secondaryRepository.count();
    }

    public Boolean verify() {
        final String uri = "http://container2:8080/address-book/AddressEntry/getAllArray";
        RestTemplate restTemplate = new RestTemplate();
        int page = 0;
        finished.set(false);
        while(!finished.get()) {
            List<Integer> pageThreads = new ArrayList<Integer>();
            for(int i=0; i< NUM_THREADS; i++) {
                pageThreads.add(page+i);
            }
            Stream<Boolean> temp  =pageThreads.parallelStream().map((i) -> {
                String result = restTemplate.getForObject( uri+"/"+(i), String.class);
                return (verifyBatch(result));
            });
            List<Boolean> result =  (temp.collect(Collectors.toList()));

            if (result.contains((Boolean)null)) return false;
            finished.compareAndSet(false,!result.contains((Boolean)false));
            page += NUM_THREADS;
        }
        return true;
    }
}
