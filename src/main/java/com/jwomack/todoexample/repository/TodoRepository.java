package com.jwomack.todoexample.repository;

import com.jwomack.todoexample.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
