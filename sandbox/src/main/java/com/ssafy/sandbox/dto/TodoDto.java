package com.ssafy.sandbox.dto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="todos")
@Data
public class TodoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String content;
    @Column
    boolean completed;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    String createdAt;
    @Column(name = "user_id")
    int userId;

    public TodoDto() {

    }
}
