package com.yuliiaskrypnyk.java.springrecapproject.todo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    TodoRepository todoRepository = mock(TodoRepository.class);
    IdService idService = mock(IdService.class);
    TodoService todoService = new TodoService(todoRepository, idService);

    @Test
    void findAllTodos() {
        //GIVEN
        Todo t1 = new Todo("1", "d1", "OPEN");
        Todo t2 = new Todo("2", "d2", "OPEN");
        Todo t3 = new Todo("3", "d3", "OPEN");
        List<Todo> todos = List.of(t1, t2, t3);

        when(todoRepository.findAll()).thenReturn(todos);

        //WHEN
        List<Todo> actual = todoService.findAllTodos();

        //THEN
        verify(todoRepository).findAll();
        assertEquals(todos, actual);
    }

    @Test
    void addTodo(){
        //GIVEN
        NewTodo newTodo = new NewTodo("Test-Description", "OPEN");
        Todo todoToSave = new Todo("Test-Id", "Test-Description", "OPEN");

        when(idService.randomId()).thenReturn("Test-Id");
        when(todoRepository.save(todoToSave)).thenReturn(todoToSave);

        //WHEN
        Todo actual = todoService.addTodo(newTodo);

        //THEN
        verify(idService).randomId();
        verify(todoRepository).save(todoToSave);
        assertEquals(todoToSave, actual);
    }
}