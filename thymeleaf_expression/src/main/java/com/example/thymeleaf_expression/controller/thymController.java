package com.example.thymeleaf_expression.controller;

import com.example.thymeleaf_expression.models.GiangVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class thymController {


    @GetMapping("/hello")
    public String hello(Model model){
        // ${...}
        model.addAttribute("mess", "phạm sơn đẹp trai");

        // *{...}
        GiangVien giangVien = new GiangVien("1", "sơn", "Hòa Bình");
        model.addAttribute("giangVien", giangVien);


        return "hello";
    }

}
