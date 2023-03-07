package com.example.spring_curd_jpa.repository;

import com.example.spring_curd_jpa.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
}
