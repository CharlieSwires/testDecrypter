package restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import primary.PrimaryMongoBeanRepository;
import secondary.SecondaryMongoBeanRepository;

@Service
public class DecrypterService {

    @Autowired
    private PrimaryMongoBeanRepository primaryRepository;

    @Autowired
    private SecondaryMongoBeanRepository secondaryRepository;

    public Boolean start() {
       List<primary.PrimaryMongoBean> list = this.primaryRepository.findAll();
       for (primary.PrimaryMongoBean item : list) {
           secondary.SecondaryMongoBean newItem = new secondary.SecondaryMongoBean();
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
       return true;
    }
    
    public Integer stop() {
        List<secondary.SecondaryMongoBean> list = this.secondaryRepository.findAll();
        return list.size();
    }


}
