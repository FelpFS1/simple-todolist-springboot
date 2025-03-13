package com.felipefariasdev.simple_todolist.service;

import com.felipefariasdev.simple_todolist.entity.Todo;
import com.felipefariasdev.simple_todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Todo findById(Long id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.get();
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
