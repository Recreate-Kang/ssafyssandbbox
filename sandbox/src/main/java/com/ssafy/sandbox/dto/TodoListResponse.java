package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.vo.Todo;
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
