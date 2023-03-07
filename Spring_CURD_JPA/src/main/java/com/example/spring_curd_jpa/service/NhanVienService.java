package com.example.spring_curd_jpa.service;

import com.example.spring_curd_jpa.models.NhanVien;
import com.example.spring_curd_jpa.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository repository;

    public List<NhanVien> findAlls() {
        List<NhanVien> list = new ArrayList<>();
        repository.findAll().forEach(s -> list.add(s));
        return list;
    }

    public NhanVien getOne(String id){
       return repository.getOne(id);
    }

    public void delete(String id){
       repository.deleteById(id);
    }

    public NhanVien saveOrUpdate(NhanVien nv){
        return repository.save(nv);
    }

}
