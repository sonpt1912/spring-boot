package com.example.spring_email.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSenderImpl();
    }

    @Bean
    public VelocityEngine velocityEngine(){
        return new VelocityEngine();
    }

}
