package com.jwomack.todoexample.controller;

import com.jwomack.todoexample.model.AddTodoRequest;
import com.jwomack.todoexample.model.GetAllTodoResponse;
import com.jwomack.todoexample.model.PutTodoRequest;
import com.jwomack.todoexample.model.Todo;
import com.jwomack.todoexample.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public GetAllTodoResponse getTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody AddTodoRequest todoRequest) {
        return todoService.addTodo(todoRequest);
    }

    @PutMapping("/todos")
    public Todo putTodo(@RequestBody PutTodoRequest todoRequest) {
        return todoService.putTodo(todoRequest);
    }
}
