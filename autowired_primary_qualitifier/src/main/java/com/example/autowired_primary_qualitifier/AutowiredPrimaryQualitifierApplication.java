package com.example.autowired_primary_qualitifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AutowiredPrimaryQualitifierApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(AutowiredPrimaryQualitifierApplication.class, args);
        Girl girl = context.getBean(Girl.class);
        System.out.println("Girl Instance: " + girl);
        System.out.println("Girl outfit: " + girl.getOutfit().wear());
    }

}
