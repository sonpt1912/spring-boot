package com.example.jpa_curd_query.repository;

import com.example.jpa_curd_query.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmRepository extends JpaRepository<Employee, Integer> {
    // c1: sử dụng cacách đặt tên biến cho hàm
    // dễ
    Employee findEmployeeById(int id);

    List<Employee> findAllByNameIgnoreCase(String name);

    List<Employee> findAllByAgeIsBetween(int min, int max);

    List<Employee> findAllByNameOrderByNameDesc(String name);

    // c2: sử dụng @Query
    // khi sử dụng query thì tên method không còn tác dụng nữa;
    // đây là JPQL (Hibernate)
    // set giá trị mặc định: ?{number}
    // giá trị sẽ lấy theo thứ tự các tham số
    @Query("SELECT e from Employee e WHERE e.id = ?1")
    // ?1 = id
    Employee getOneById(int id);

    // set name cho giá trị

    // đây là nativeQuery
    @Query(value = "SELECT * FROM Employee ", nativeQuery = true)
    List<Employee> getAll();


    // có thể đặt tên biến
    @Query("SELECT e from Employee e WHERE e.id = :status")
    List<Employee> getByName(@Param(("status")) int id);
}
