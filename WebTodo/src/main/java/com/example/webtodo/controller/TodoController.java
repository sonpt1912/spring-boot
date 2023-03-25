package com.example.webtodo.controller;

import com.example.webtodo.models.Todo;
import com.example.webtodo.service.IService;
import com.example.webtodo.service.impl.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    private IService<Todo> service = new TodoService();

    /*
     * @RequestParam dùng để đánh dấu một biến là request
     * param trong request gửi lên server.
     * no sẽ gán dữ liệu của param - name tuương ứng vào biến
     * */

    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // trả về đối tượng todoList.

        model.addAttribute("listTD", service.findAll(limit));
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }


    /*
     * @ModelAttribute đánh dấu đối tượng to_do gửi lên bở from request
     * */

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(service.add(todo))
                .map(t -> "succes") // trả về nếu save thành cng
                .orElse("faild"); // trả về nếu add thất bại
    }
}
