package com.example.spring_curd_jpa.controller;

import com.example.spring_curd_jpa.models.NhanVien;
import com.example.spring_curd_jpa.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // được dùng để sử dụng kiểu ResautAPI
@Controller // được dùng để trả về view (JSP, Thymeleaf)
public class NhanVienController {
    @Autowired
    // khởi tọa 1 đối tượng mà không cần phải dùng NhanVienService service = new NhanVienService();
    private NhanVienService service;

    @GetMapping("/")
    // @GetMapping: request ở dạng get
    public List<NhanVien> findAlls(){
        return service.findAlls();
    }

    // @PathVariable: nó sẽ lấy biến ở đường dẫn url
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public NhanVien getOne(@PathVariable("id") String id)
    {
        return service.getOne(id);
    }

    // @PathVariable: nó sẽ lấy biến ở đường dẫn url
    @DeleteMapping("/delete/{id}")
    // request ở dạng xóa
    public void delete(@PathVariable("id") String id)
    {
         service.delete(id);
    }

    @PutMapping("/save")
    // request ở dạng thêm hoặc update
    public NhanVien saveOrUpdate(@RequestBody  NhanVien nhanVien){
        return service.saveOrUpdate(nhanVien);
    }
}
