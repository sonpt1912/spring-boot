package com.example.jpa_curd_query.service.impl;

import com.example.jpa_curd_query.models.Employee;
import com.example.jpa_curd_query.repository.EmRepository;
import com.example.jpa_curd_query.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmService implements IService {

    @Autowired
    private EmRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.getAll();
    }
}
