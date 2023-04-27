package com.example.resfulapi_document_swagger.services;

import com.example.resfulapi_document_swagger.models.Users;
import com.example.resfulapi_document_swagger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<Users> getAll() {
        return repository.findAll();
    }

    public Users getOne(long id) {
        return repository.findById(id).get();
    }
}
