package restful;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import primary.PrimaryMongoBean;
import primary.PrimaryMongoBeanRepository;
import secondary.SecondaryMongoBean;
import secondary.SecondaryMongoBeanRepository;

@Service
public class DecrypterService implements InitializingBean{
    @Autowired
    private ApplicationContext context;


    @Autowired
    private PrimaryMongoBeanRepository primaryRepository;

    @Autowired
    private SecondaryMongoBeanRepository secondaryRepository;

    public Boolean start() {
       List<PrimaryMongoBean> list = this.primaryRepository.findAll();
       for (PrimaryMongoBean item : list) {
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
       return true;
    }
    
    public Integer stop() {
        List<SecondaryMongoBean> list = this.secondaryRepository.findAll();
        return list.size();
    }

    @Override
    public void afterPropertiesSet() {
        context.getBean("mongoTemplate");
    }
}
