package com.example.todoapi.model;

import jakarta.annotation.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")
public class Todo {
   @Id
   private String id;
   private String title;
   private String description;
   private boolean completed;
   private Priority priority;
   @CreatedDate
   private LocalDateTime createdAt;
   @LastModifiedDate
   private LocalDateTime updatedAt;
   public enum  Priority {
      HIGH,
      MEDIUM,
      LOW
   }
}
