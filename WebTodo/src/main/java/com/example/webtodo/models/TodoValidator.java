package com.example.webtodo.models;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

/*
 * đối tượng  này được sử dụng để kiểm tra xem  một object to_do có hợp lệ hay không
 * @Param to_do
 * @return
 * */
public class TodoValidator {
    public boolean isValid(Todo todo) {
        return Optional.ofNullable(todo).filter(t -> !StringUtils.isEmpty(t.getTitle())) // kiểm tra title khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getDetail())) // kiểm tra detail khác rỗng
                .isPresent(); // trả về true nu hợp lệ, ngược lại false
    }
}
