package com.example.todoapi.service;

import com.example.todoapi.dto.TodoRequestDTO;
import com.example.todoapi.dto.TodoResponseDTO;
import com.example.todoapi.exception.TodoNotFoundExecption;
import com.example.todoapi.model.Todo;
import com.example.todoapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    public TodoResponseDTO createTodo(TodoRequestDTO requestDTO) {
        Todo todo = new Todo();
        todo.setTitle(requestDTO.getTitle());
        todo.setDescription(requestDTO.getDescription());
        todo.setPriority(requestDTO.getPriority());
        todo.setCompleted(false);
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponseDTO(savedTodo);
    }
    public List<TodoResponseDTO> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponseDTO::new)
                .collect(Collectors.toList());
    }
    public TodoResponseDTO updateTodo (String id, TodoRequestDTO requestDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new TodoNotFoundExecption(id));
        todo.setTitle(requestDTO.getTitle());
        todo.setDescription(requestDTO.getDescription());
        todo.setPriority(requestDTO.getPriority());
        todo.setUpdatedAt(LocalDateTime.now());
        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponseDTO(updatedTodo);
    }
    public TodoResponseDTO toggleTodo (String id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundExecption(id));
        todo.setCompleted(!todo.isCompleted());
        todo.setUpdatedAt(LocalDateTime.now());
        Todo updatedTodo = todoRepository.save(todo);
        return new TodoResponseDTO(updatedTodo);
    }
    public void deleteTodo(String id) {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundExecption(id);
        }
        todoRepository.deleteById(id);
    }
    public List<TodoResponseDTO> getTodosByStatus(boolean completed) {
        return todoRepository.findByCompleted(completed)
                .stream()
                .map(TodoResponseDTO::new)
                .collect(Collectors.toList());
    }
    public List<TodoResponseDTO> searchTodos(String keyword) {
        return todoRepository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(TodoResponseDTO::new)
                .collect(Collectors.toList());
    }
}
