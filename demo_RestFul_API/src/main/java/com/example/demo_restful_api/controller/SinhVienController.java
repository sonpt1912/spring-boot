package com.example.demo_restful_api.controller;

import com.example.demo_restful_api.models.SinhVien;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 * lưu ý, @RequestMapping ở class, sẽ tác động tới
 * tất cả các RequestMapping ở bên trong nó.
 *
 * mọi request ở trong method sẽ được gắn thêm prefix
 * /sonpt
 * */
@RestController
@RequestMapping("/sonpt")
public class SinhVienController {

    private List<SinhVien> sinhViens = new ArrayList<>();

    // bạn còn nhớ @PostConstruct dùng để làm gì chứ?
    // nếu ko thif coi lại đi =))

    @PostConstruct
    public void init() {
        // thêm null vào list để bỏ qua vị trí số 0;
        sinhViens.add(null);
        sinhViens.add(new SinhVien(1, "sonpt", 19));
        sinhViens.add(new SinhVien(2, "duongnnt", 19));
        sinhViens.add(new SinhVien(3, "tuanbc", 19));
        sinhViens.add(new SinhVien(4, "thanhpv", 19));
        sinhViens.add(new SinhVien(5, "dungnd", 19));
    }

    @GetMapping("/getlist")
    public List<SinhVien> getListSV() {
        return sinhViens;
    }

    /*
     * phần path URL bạn muốn lấy thông tin sẽ để
     * trong ngoặc kép {}
     * */

    @GetMapping("/sinhVien/{sinhVienId}")
    public SinhVien getSinhVien(@PathVariable(name = "sinhVienId") int id) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /sinhVien/{sinhVienId}

        return sinhViens.get(id);
    }

    /*
     * @RequestBody nói với Spring Boot rằng hãy chuyển
     * Json trong requestBody thành đối tượng Todo
     * */

    @PutMapping("/sinhVien/{sinhvienId}")
    public SinhVien editSinhVien(@PathVariable(name = "sinhvienId") int id, @RequestBody SinhVien sinhVien) {
        sinhViens.set(id, sinhVien);
        // trả về đối tượng sau khi đã edit
        return sinhVien;
    }

    @DeleteMapping("/sinhVien/{sinhVienId}")
    public ResponseEntity deleteSinhVien(@PathVariable(name = "sinhVienId") int id) {
        sinhViens.remove(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sinhVien")
    public ResponseEntity addSinhVien(@RequestBody SinhVien sinhVien) {
        sinhViens.add(sinhVien);
        //trả về response với STATUS CODE == 200 (ok)
        // body sẽ chứa thông tin về đối tượng sinhvien vừa dudowdjc tạo
        return ResponseEntity.ok().body(sinhVien);
    }


}
