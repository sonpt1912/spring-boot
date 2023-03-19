package com.example.demowebtodo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("pson/") // đường dẫn dudowjc cấu hình thành: http://localhost8080/pson/
@org.springframework.stereotype.Controller
public class Controller {
    /*
     * có 2 cách để tạo path:
     * c1: dùng các biến trực tiếp như là @GetMapping, @PostMapping...
     * c2: sử dụng biến gián tiếp như: @RequestMapping(value = "", method = RequestMethod.GET) == @GetMapping("")..vv..
     * */

    // => đường dẫn cos thể trùng nhau nhưng phải phân biệt giữa các method

    // đường dẫn sẽ là: http://localhost8080/pson/addTodo và method laf GET
    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodo(Model model) {
        return "todo";
    }

    // đường dẫn sẽ là: http://localhost8080/pson/addTodo và method laf POST
    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addTodo() {
        return "suuces";
    }
}
