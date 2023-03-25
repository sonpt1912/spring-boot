package com.example.curd_jpa.repository;

import com.example.curd_jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<Employee, Integer> {
}
