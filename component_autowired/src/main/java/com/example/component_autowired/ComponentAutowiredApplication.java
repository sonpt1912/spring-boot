package com.example.component_autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ComponentAutowiredApplication {

    public static void main(String[] args) {
        // ApplicationContext chính là một container chứa các bean trong java
       ApplicationContext context =  SpringApplication.run(ComponentAutowiredApplication.class, args);

        // khi chạy chương trình các các context sẽ chứa các bean có đánh dấu @component

        // lấy bean ra băng cách
        Outfit outfit = context.getBean(Outfit.class);
        // in thử xem bean là gì
        System.out.println("[1]" + outfit);
        // dùng hàm were của class bikini
        outfit.wear();

        Girl girl = context.getBean(Girl.class);
        System.out.println("[3] Girl Instance: " + girl);
        System.out.println("[4] Girl outfit: " + girl.outfit );

        girl.outfit.wear();
    }

}
