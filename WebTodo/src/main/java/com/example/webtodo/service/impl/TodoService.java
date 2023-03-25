package com.example.webtodo.service.impl;

import com.example.webtodo.models.Todo;
import com.example.webtodo.models.TodoValidator;
import com.example.webtodo.repository.TodoRepository;
import com.example.webtodo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements IService<Todo> {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoValidator validator;
    /*
     * lấy ra danh sách List<To_do>
     *
     * @Param limit - giới hạn số lượng lấy ra
     *
     * @Return trả về danh sách List<To_do> dựa theo limit,
     * nếu limit == null thì trả findAll()
     * */

    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit).map(value -> repository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> repository.findAll());
    }

    /*
     * thêm một To_do mới vào danh sách công vi cần làm
     *
     * @Return trả về đối tượng to_do sau khi lưu vào DB,
     * trả về null nếu không thành công.
     *
     * */

    public Todo add(Todo todo) {
        if (validator.isValid(todo)) {
            return repository.save(todo);
        } else {
            return null;
        }
    }
}
