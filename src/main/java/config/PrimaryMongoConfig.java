package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "primary",
        mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {

}