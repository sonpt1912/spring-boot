package com.example.curd_jpa.controller;

import com.example.curd_jpa.model.Employee;
import com.example.curd_jpa.service.IService;
import com.example.curd_jpa.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IService service = new EmployeeService();

    private List<Employee> listEmployee = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        if (listEmployee.isEmpty()) {
            listEmployee = service.findAll();
        }

        model.addAttribute("listEm", listEmployee);
        return "index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id", required = false) int id, Model model) {
        Employee employee = service.getOne(id);
        model.addAttribute("emp", employee);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") int id, Model model) {
        service.delete(id);
        listEmployee = service.findAll();
        model.addAttribute("listEm", listEmployee);
        return "index";
    }

    // add

    @PostMapping("/add")
    public String add(@ModelAttribute Employee employee, Model model) {
        service.add(employee);
        listEmployee = service.findAll();
        model.addAttribute("listEm", listEmployee);
        return "index";
    }

    @GetMapping("/add")
    public String viewAdd(Model model){
        model.addAttribute("emp", new Employee());
        return "add";
    }

    // update

    @GetMapping("/update")
    public String viewUpdate(@RequestParam(name = "id") int id, Model model){
        Employee employee = service.getOne(id);
        model.addAttribute("emp", employee);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee){
        service.update(employee.getId(), employee);
        return "index";
    }
}
