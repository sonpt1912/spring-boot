package com.example.demowebtodo.service;

import com.example.demowebtodo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    public List<Todo> listFake() {
        List<Todo> list = new ArrayList<>();
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        list.add(new Todo("đi chơi", "đi ăn"));
        return list;
    }
}
