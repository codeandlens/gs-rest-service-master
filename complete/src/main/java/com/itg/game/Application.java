package com.itg.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

     public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
     }
     
    
     @Bean
     public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
                                        MongoMappingContext context) {

         MappingMongoConverter converter =
                 new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
         converter.setTypeMapper(new DefaultMongoTypeMapper(null));

         MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

         return mongoTemplate;

     }
    
}
