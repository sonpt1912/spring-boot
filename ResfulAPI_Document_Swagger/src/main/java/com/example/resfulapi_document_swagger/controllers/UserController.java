package com.example.resfulapi_document_swagger.controllers;

import com.example.resfulapi_document_swagger.models.Users;
import com.example.resfulapi_document_swagger.repositories.UserRepository;
import com.example.resfulapi_document_swagger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<Users> listUser = new ArrayList<>();

    @Autowired
    private UserService service;

    @GetMapping("/get-all")
    public List<Users> getAll() {
        return service.getAll();
    }
}
