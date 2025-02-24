package com.yuliiaskrypnyk.java.springrecapproject.todo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public record Todo(
        String id,
        String description
) {
}