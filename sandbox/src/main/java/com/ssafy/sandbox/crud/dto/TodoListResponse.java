package com.ssafy.sandbox.crud.dto;

import com.ssafy.sandbox.crud.vo.Todo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoListResponse {
    private List<Todo> todos;

    public TodoListResponse(List<Todo> todos){
        this.todos = todos;
    }
}
