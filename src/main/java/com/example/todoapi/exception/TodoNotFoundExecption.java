package com.example.todoapi.exception;

public class TodoNotFoundExecption extends RuntimeException {
    public  TodoNotFoundExecption(String id) {
        super("Todo Not Found with id: " + id);
    }
}
