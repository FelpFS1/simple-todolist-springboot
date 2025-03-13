package com.felipefariasdev.simple_todolist.controller;

import com.felipefariasdev.simple_todolist.entity.Todo;
import com.felipefariasdev.simple_todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> findAll(){
        return todoService.findAll();
    }
    @GetMapping(value = "/{id}")
    public Todo findById(@PathVariable("id") Long id){
        return todoService.findById(id);
    }

    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping(value = "/{id}")
    public List<Todo> delete(@PathVariable("id") long id){
        return todoService.delete(id);
    }
 }
