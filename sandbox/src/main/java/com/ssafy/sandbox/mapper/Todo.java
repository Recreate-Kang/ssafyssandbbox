package com.ssafy.sandbox.mapper;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String content;
    @Column
    boolean completed;
    @Column
    String createdAt;
    @Column
    int userId;

    public Todo() {

    }
}
