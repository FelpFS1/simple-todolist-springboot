package com.felipefariasdev.simple_todolist.repository;

import com.felipefariasdev.simple_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
