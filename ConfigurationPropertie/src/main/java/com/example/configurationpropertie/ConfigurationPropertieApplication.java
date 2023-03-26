package com.example.configurationpropertie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ConfigurationPropertieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationPropertieApplication.class, args);
    }

    @Autowired
    SonptProperties sonptProperties;

    public void run(String... args) throws Exception {
        System.out.println("Global variable:");
        System.out.println("\t Email: " + sonptProperties.getEmail());
        System.out.println("\t GA ID: " + sonptProperties.getGoogleAnalyticsId());
    }


}
