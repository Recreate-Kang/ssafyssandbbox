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
        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto newTodoDto) {
        TodoDto savedTodoDto = todoService.createTodos(newTodoDto); // 서비스에서 저장 메서드 호출//content와 필드명 일치해서 이미들어가있음
        return ResponseEntity.ok().body(savedTodoDto); // 저장된 TodoDto 반환
    }
    @PatchMapping("/{todoId}")
    public ResponseEntity<Map<String, Boolean>> toggleTodo(@PathVariable int todoId) {
        todoService.toggleTodo(todoId); // 서비스 메서드 호출
        Map<String, Boolean> update = Map.of("complete", Boolean.TRUE);
        return ResponseEntity.ok().body(update);
    }
    @DeleteMapping("/{todoID}")
    public ResponseEntity<Void> deleteTodo( @PathVariable int todoID) {
        todoService.deleteTodo(todoID);
        return ResponseEntity.noContent().build();
    }
}
