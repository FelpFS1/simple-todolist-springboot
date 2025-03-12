package com.felipefariasdev.simple_todolist.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_todo")
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean isCompleted;
    private Integer priority;

    public Todo(String description, Boolean isCompleted,  Integer priority) {
        this.isCompleted = isCompleted;
        this.description = description;
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
