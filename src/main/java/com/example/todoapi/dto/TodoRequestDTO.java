package com.example.todoapi.dto;

import com.example.todoapi.model.Todo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class TodoRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    @NotNull(message = "Priority is required")
    private Todo.Priority priority;
}
