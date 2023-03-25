package com.example.curd_jpa.service;

import com.example.curd_jpa.model.Employee;

import java.util.List;

public interface IService {

    List<Employee> findAll();

    Employee getOne(int id);

    void add(Employee employee);

    void delete(int id);

    void update(int id, Employee employee);
}
