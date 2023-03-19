package com.example.demowebtodo.controller;

import com.example.demowebtodo.model.Todo;
import com.example.demowebtodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private List<Todo> todos = new ArrayList<>();
    @Autowired
    private TodoService service;

    /*
     * @RequestParam: dùng để  đánh dấu một biến là request param trong request gửi lên server.
     * nó sẽ gán dữ liệu của param-name vào 1 biến tương ứng
     * */

    @GetMapping("/listTodo")
    public String getList(Model model, @RequestParam(name = "limit", required = false) Integer limit) {
        if(todos.isEmpty()){
            todos = service.listFake();
        }

        // trả về listTodo
        // nếu người dùng gửi lên limit thì trả về sub-List của listTodo
        model.addAttribute("todoList", limit != null ? todos.subList(0, limit) : todos);
        return "todo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        // thêm mới một đối tượng _todo vào model
        model.addAttribute("toDo", new Todo());
        return "add";
    }

    /*
     * @ModelAttribute(): lấy đối tượng được gửi lên bởi form request
     */
    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        // thêm đối tượng vòa list
        todos.add(todo);
        // sau đó trả về trang chủ
        return "add";
    }

}
