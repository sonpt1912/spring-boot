package com.example.webtodo.service;

import com.example.webtodo.models.Todo;

import java.util.List;

public interface IService<T> {

    Todo add(T t);

    List<T> findAll(Integer limit);

}
