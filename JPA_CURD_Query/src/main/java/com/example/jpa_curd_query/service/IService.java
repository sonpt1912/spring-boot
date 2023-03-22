package com.example.jpa_curd_query.service;

import com.example.jpa_curd_query.models.Employee;

import java.util.List;

public interface IService {
    List<Employee> findAll();
}
