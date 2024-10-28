package com.ssafy.sandbox.controller;


import com.ssafy.sandbox.dto.TodoResponse;
import com.ssafy.sandbox.mapper.Todo;
import com.ssafy.sandbox.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<TodoResponse> getTodos() {
        List<Todo> todos = todoService.getAllTodos();
        TodoResponse response = new TodoResponse(todos);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        newTodo.setCompleted(false); // 기본값 설정
        newTodo.setCreatedAt(LocalDateTime.now().toString()); // 현재 시간 설정
        newTodo.setUserId(1); // 사용자 ID 설정 (예시)

        Todo savedTodo = todoService.postTodos(newTodo); // 서비스에서 저장 메서드 호출
        System.out.println(savedTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo); // 저장된 Todo 반환
    }
    @PatchMapping("/todos")
    public ResponseEntity<Todo> patchTodo
}
