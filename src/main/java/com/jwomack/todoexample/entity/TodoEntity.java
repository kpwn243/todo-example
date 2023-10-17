package com.jwomack.todoexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.ZonedDateTime;

@Data
@Entity(name = "todo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {

    @Id
    @SequenceGenerator(name = "todo_sequence", sequenceName = "todo_sequence", allocationSize = 1)
    @GeneratedValue(generator = "todo_sequence")
    private Long id;

    private String title;
    private boolean completed;
    private ZonedDateTime createdDate;
    private ZonedDateTime updatedDate;
}
