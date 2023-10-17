package com.jwomack.todoexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutTodoRequest {
    private Long id;
    private String title;
    private boolean completed;
}
