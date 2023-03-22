package com.example.jpa_curd_query.controller;

import com.example.jpa_curd_query.models.Employee;
import com.example.jpa_curd_query.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmController {
    @Autowired
    private IService service;

    private List<Employee> listEm = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        listEm = service.findAll();
        model.addAttribute("listEm", listEm);
        return "index";
    }
}
