package com.exmaple.javatpoint.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController 
{
    @RequestMapping("/")
    public String hello()
    {
        return "xin chào bà zà cô đơn giữa trời đông giá rét";
    }
}
