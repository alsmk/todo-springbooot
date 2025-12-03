package com.example.todoapi.controller;

import com.example.todoapi.dto.TodoRequestDTO;
import com.example.todoapi.dto.TodoResponseDTO;
import com.example.todoapi.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")  // for front end
public class TodoController {
    private final TodoService todoService;
    @PostMapping
    public ResponseEntity<TodoResponseDTO> createTodo(@Valid @RequestBody TodoRequestDTO todoRequestDTO) {
        TodoResponseDTO todoResponseDTO = todoService.createTodo(todoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponseDTO);
    }
    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> getAllTodos() {
        List<TodoResponseDTO> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> getTodoById(@PathVariable String id) {
        TodoResponseDTO todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }
    @PutMapping("/{id}")
    public ResponseEntity <TodoResponseDTO> updateTodo(@PathVariable String id,  @Valid @RequestBody TodoRequestDTO todoRequestDTO) {
        TodoResponseDTO todoResponseDTO = todoService.updateTodo(id, todoRequestDTO);
        return ResponseEntity.ok(todoResponseDTO);

    }
    @GetMapping("/search")
    public ResponseEntity <List <TodoResponseDTO>> searchTodo(@RequestParam String title) {
        List<TodoResponseDTO> todos = todoService.searchTodos(title);
        return ResponseEntity.ok(todos);
    }

}
