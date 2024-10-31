package com.ssafy.sandbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoListResponse {
    private List<TodoDto> todos;

    public TodoListResponse(List<TodoDto> todos){
        this.todos = todos;
    }

}
