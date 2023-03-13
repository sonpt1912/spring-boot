package com.example.preconstruct_predestroy;

import com.example.preconstruct_predestroy.models.Girls;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PreConstructPreDestroyApplication {

    public static void main(String[] args) {
        System.out.println("> trớc khi các bean được khởi ( IoC Container ) tạo");
        // application chứa toàn bộ các bean
      ApplicationContext context = SpringApplication.run(PreConstructPreDestroyApplication.class, args);

        System.out.println("> sau khi các bean được khởi ( IoC Container ) tạo");

        //
        // lúc này context sẽ chứa các bean được đánh dấu bởi component
        Girls girls = context.getBean(Girls.class);

        //
        System.out.println("> trước khi IoC container destroy các bean girl");

        System.out.println("> Sau khi IoC Container destroy Girl");

    }

}
