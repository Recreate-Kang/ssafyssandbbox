package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.mapper.Todo;

import java.util.List;

public class TodoResponse {
    private List<Todo> todos;

    public TodoResponse(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
