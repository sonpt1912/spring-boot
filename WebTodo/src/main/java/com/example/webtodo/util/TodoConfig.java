package com.example.webtodo.util;

import com.example.webtodo.models.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    /*
     * tạo ra Bean TodoCalidator để sử dụng sau này
     * @Return
     * */
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}
