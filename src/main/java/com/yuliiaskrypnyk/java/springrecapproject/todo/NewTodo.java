package com.yuliiaskrypnyk.java.springrecapproject.todo;

public record NewTodo(
        String description,
        TodoStatus status
) {
}
