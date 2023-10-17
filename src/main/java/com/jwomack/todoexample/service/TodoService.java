package com.jwomack.todoexample.service;

import com.jwomack.todoexample.entity.TodoEntity;
import com.jwomack.todoexample.exception.ResourceNotFoundException;
import com.jwomack.todoexample.model.AddTodoRequest;
import com.jwomack.todoexample.model.GetAllTodoResponse;
import com.jwomack.todoexample.model.PutTodoRequest;
import com.jwomack.todoexample.model.Todo;
import com.jwomack.todoexample.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public GetAllTodoResponse getAllTodos() {
        Iterable<TodoEntity> todoEntities = todoRepository.findAll();
        List<Todo> todos = StreamSupport.stream(todoEntities.spliterator(), false)
                .map(todoEntity -> Todo.builder()
                        .id(todoEntity.getId())
                        .title(todoEntity.getTitle())
                        .completed(todoEntity.isCompleted())
                        .createdDate(todoEntity.getCreatedDate())
                        .updatedDate(todoEntity.getUpdatedDate())
                        .build())
                .collect(Collectors.toList());

        return GetAllTodoResponse.builder()
                .todos(todos)
                .build();
    }

    public Todo addTodo(AddTodoRequest todoRequest) {
        TodoEntity todoEntity = TodoEntity.builder()
                .title(todoRequest.getTitle())
                .createdDate(ZonedDateTime.now())
                .updatedDate(ZonedDateTime.now())
                .build();
        TodoEntity todo = todoRepository.save(todoEntity);
        return Todo.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.isCompleted())
                .createdDate(todo.getCreatedDate())
                .updatedDate(todo.getUpdatedDate())
                .build();
    }

    public Todo putTodo(PutTodoRequest todoRequest) {
        TodoEntity todoEntity = todoRepository.findById(todoRequest.getId())
                .orElseThrow(ResourceNotFoundException::new);

        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setCompleted(todoRequest.isCompleted());
        todoEntity.setUpdatedDate(ZonedDateTime.now());
        TodoEntity todo = todoRepository.save(todoEntity);

        return Todo.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.isCompleted())
                .createdDate(todo.getCreatedDate())
                .build();
    }
}
