package com.example.hibernate_validator.service;

import com.example.hibernate_validator.models.Employee;
import com.example.hibernate_validator.repository.EmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmService {

    @Autowired
    private EmRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public void saveOrUpdate(Employee employee) {
        repository.save(employee);
    }

}
