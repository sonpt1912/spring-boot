package com.example.preconstruct_predestroy.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Girls {
    @PostConstruct
   public void postConstruct(){
       System.out.println(">>>>> đối tươợng sau khi khởi chạy sẽ chạy hàm này");
   }

   @PreDestroy
    public void preDestroy(){
       System.out.println(">>>>> đối tượng sau khi shut down sẽ chạy vào đây");
   }
}
