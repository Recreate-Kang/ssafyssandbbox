package com.ssafy.sandbox.controller;


import com.ssafy.sandbox.dto.TodoDto;
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
    public ResponseEntity<Map<String, List<TodoDto>>> getTodos() {
        List<TodoDto> todoDtos = todoService.getAllTodos();
        Map<String, List<TodoDto>> response = new HashMap<>();
        response.put("todos", todoDtos);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto newTodoDto) {
        newTodoDto.setCompleted(false); // 기본값 설정
        newTodoDto.setCreatedAt(LocalDateTime.now().toString()); // 현재 시간 설정
        newTodoDto.setUserId(1); // 사용자 ID 설정 (예시)
        TodoDto savedTodoDto = todoService.createTodos(newTodoDto); // 서비스에서 저장 메서드 호출//content와 필드명 일치해서 이미들어가있음
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodoDto); // 저장된 TodoDto 반환
    }
    @PatchMapping("/{todoId}")
    public ResponseEntity<Map<String, Boolean>> toggleTodo(@PathVariable int todoId) {
        todoService.toggleTodo(todoId); // 서비스 메서드 호출
        Map<String, Boolean> update = new HashMap<>();
        update.put("complete", Boolean.TRUE);
        return ResponseEntity.ok().body(update);
    }
    @DeleteMapping("/{todoID}")
    public ResponseEntity<Void> deleteTodo( @PathVariable int todoID) {
        todoService.deleteTodo(todoID);
        return ResponseEntity.ok().build();
    }
}
