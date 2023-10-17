package com.jwomack.todoexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private boolean completed;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;
}
