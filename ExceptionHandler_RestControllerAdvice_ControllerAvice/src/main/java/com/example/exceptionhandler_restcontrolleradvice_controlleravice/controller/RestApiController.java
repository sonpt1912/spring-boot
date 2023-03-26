package com.example.exceptionhandler_restcontrolleradvice_controlleravice.controller;


import com.example.exceptionhandler_restcontrolleradvice_controlleravice.models.GiangVien;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {
    private List<GiangVien> listGV = new ArrayList<>();

    // phần pathURL muốn lấy thng tin sẽ để trong {}
    @GetMapping("/giang-vien/{gvId}")
    public GiangVien getGiangVien(@PathVariable(name = "gvId") int id) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngặc kép /giang-vien/{gvId}
        return listGV.get(id);
    }
}
