package restful;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import secondary.SecondaryMongoBeanRepository;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses= {
        SecondaryMongoBeanRepository.class})
public class Application extends SpringBootServletInitializer{

//@SpringBootApplication
//public class MainApp{
//   public static void main(String[] args) {
//       SpringApplication.run(MainApp.class, args);
//   }
}
