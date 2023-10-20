package com.example.springwagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/get-one/{id}")
    public String getOne(Long id){
        if(id == 0){
            return "thành công";
        }else{
            return "không thanành công";
        }
    }

}
