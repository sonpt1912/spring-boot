package com.example.spring_image.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public Cloudinary getCloudiary() {

        Map config = new HashMap();
        config.put("cloud_name", "dm256lpnu");
        config.put("api_key", "463632651578279");
        config.put("api_secret", "CEQdGRFAMKw29flEN7UELfTm-Wg");
        config.put("secure", true);

        return new Cloudinary(config);
    }

}
