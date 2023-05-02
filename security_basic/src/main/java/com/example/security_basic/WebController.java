package com.example.security_basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home"; // trả về home.html
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello"; // trả về hello.html
    }



}
