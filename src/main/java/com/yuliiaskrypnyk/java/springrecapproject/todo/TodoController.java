package com.yuliiaskrypnyk.java.springrecapproject.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping
    public Todo postTodo(@RequestBody NewTodo newTodo) {
        return todoService.addTodo(newTodo);
    }

    @PutMapping("{id}")
    public Todo putTodo(@RequestBody UpdateTodo todo, @PathVariable String id) {
        return todoService.updateTodo(todo, id);
    }
}
