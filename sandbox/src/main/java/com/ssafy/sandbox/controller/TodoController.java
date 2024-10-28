package com.ssafy.sandbox.controller;


import com.ssafy.sandbox.mapper.Todo;
import com.ssafy.sandbox.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<Map<String, List<Todo>>> getTodos() {
        System.out.println("handle getTodos");
        List<Todo> todos = todoService.getAllTodos();

        //형식에 맞춰 감싸기
        Map<String, List<Todo>> response = new HashMap<>();
        response.put("todos", todos);

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        System.out.println("handle posttodos");
        newTodo.setCompleted(false); // 기본값 설정
        newTodo.setCreatedAt(LocalDateTime.now().toString()); // 현재 시간 설정
        newTodo.setUserId(1); // 사용자 ID 설정 (예시)

        Todo savedTodo = todoService.postTodos(newTodo); // 서비스에서 저장 메서드 호출
        System.out.println(savedTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo); // 저장된 Todo 반환
    }
    @PatchMapping("/{todoId}")
    public ResponseEntity<Map<String, Boolean>> updateTodoPatch(
            @PathVariable int todoId
            ) {
        System.out.println("handle patch");
        todoService.updateTodo(todoId); // 서비스 메서드 호출
        Map<String, Boolean> update = new HashMap<>();
        update.put("complete", new Boolean(true));
        return ResponseEntity.ok().body(update);
    }
    @DeleteMapping("/{todoID}")
    public ResponseEntity<Void> deleteTodo( @PathVariable int todoID
    ) {
        System.out.println("delete path");
        todoService.deleteTodo(todoID);
        return ResponseEntity.ok().build();
    }
}
