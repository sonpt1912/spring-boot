package com.example.curd_jpa.service.impl;

import com.example.curd_jpa.model.Employee;
import com.example.curd_jpa.repository.IRepository;
import com.example.curd_jpa.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IService {
    @Autowired
    private IRepository repository;

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee getOne(int id) {
        return repository.getOne(id);
    }

    public void add(Employee employee) {
        repository.save(employee);
    }

    public void delete(int id) {
        Employee e = this.getOne(id);
        repository.delete(e);
    }

    public void update(int id, Employee employee) {
        try {
            Employee emp = this.getOne(id);
            emp = employee;
            repository.save(emp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
