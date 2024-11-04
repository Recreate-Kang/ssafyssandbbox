package com.ssafy.sandbox.vo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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
    LocalDateTime createdAt;
    @Column(name = "user_id")
    int userId;

    public TodoDto() {

    }
}
