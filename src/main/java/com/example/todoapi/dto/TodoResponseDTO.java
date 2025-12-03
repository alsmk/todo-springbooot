package com.example.todoapi.dto;

import com.example.todoapi.model.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDTO {
    private String id;
    private String title;
    private String description;
    private boolean completed;
    private Todo.Priority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TodoResponseDTO( Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.completed = todo.isCompleted();
        this.priority = todo.getPriority();
        this.createdAt = todo.getCreatedAt();
        this.updatedAt = todo.getUpdatedAt();
    }

}
