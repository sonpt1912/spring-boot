package com.example.hibernate_validator.controller;

import com.example.hibernate_validator.models.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmController {

    /**
     * đánh dấu object với @Valid để validator tự động kiểm tra
     * object có hợp lệ hay không
     */

    @PostMapping("/add")
    public Object createUser(@Valid @RequestBody Employee employee) {
        return employee;
    }

}
