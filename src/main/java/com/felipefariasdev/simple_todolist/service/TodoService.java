package com.felipefariasdev.simple_todolist.service;

import com.felipefariasdev.simple_todolist.entity.Todo;
import com.felipefariasdev.simple_todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return findAll();
    };

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return findAll();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return findAll();
    }

}
