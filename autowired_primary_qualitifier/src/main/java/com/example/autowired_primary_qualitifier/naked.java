package com.example.autowired_primary_qualitifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
* có 2 cách để loại bỏ lỗi
* c1: sử dụng @Primary
* c2: sử dụng @Qualitifier (đặt tên cho component)
* */

// đánh dấu là 1 bean
@Component("naked") // c2: đặt tên cho component
//@Primary // c1
public class naked implements Outfit{
    public String wear(){
        return " không mặc gì";
    }
}
