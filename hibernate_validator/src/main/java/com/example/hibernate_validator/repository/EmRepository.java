package com.example.hibernate_validator.repository;

import com.example.hibernate_validator.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmRepository extends JpaRepository<Employee, Long> {
}
