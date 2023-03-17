package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// đánh dấu là một contrller
// nơi tiếp nhâ các request tuwf phía người dùng
// controller sẽ trả về view giao diện html,jsp
@Controller
public class HelloController {

    // đón nhận request GET
    @GetMapping("/")  // nếu người dùng request tới địa chỉ "/"
    public String index(){
        return "index"; // trả về file index.html
    }


    // khi người dùng request tới địa chỉ "/about"
    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/hello")
    // RequestParam name: lấy name ở file index.html sau đó gán giá trị vào biến String
    // Model: là Object của Spring Boot, được gán vào trong mọi request.
    public String hello(@RequestParam(name = "nameIndex", required = false, defaultValue = "") String name, Model model){
        // gắn vào model giá trị name nhận được
        model.addAttribute("nameHello", name);
        return "hello";
        // trả về file hello.html cùng với thông tin trong object model
    }
}
