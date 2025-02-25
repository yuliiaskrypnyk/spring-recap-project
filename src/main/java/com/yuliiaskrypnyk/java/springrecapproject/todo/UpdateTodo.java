package com.yuliiaskrypnyk.java.springrecapproject.todo;

public record UpdateTodo(
        String description,
        TodoStatus status
) {
}
