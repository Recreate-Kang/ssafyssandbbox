package com.ssafy.sandbox.crud.controller;


import com.ssafy.sandbox.crud.vo.Todo;
import com.ssafy.sandbox.crud.dto.TodoListResponse;
import com.ssafy.sandbox.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<TodoListResponse> getTodos() {
        TodoListResponse response = todoService.getAllTodos();
        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodoDto) {
        Todo savedTodoDto = todoService.createTodos(newTodoDto); // 서비스에서 저장 메서드 호출//content와 필드명 일치해서 이미들어가있음
        return ResponseEntity.ok().body(savedTodoDto); // 저장된 TodoDto 반환
    }
    @PatchMapping("/{todoId}")
    public ResponseEntity<Map<String, Boolean>> toggleTodo(@PathVariable int todoId) {
        Map<String, Boolean> update = todoService.toggleTodo(todoId);
        return ResponseEntity.ok().body(update);
    }
    @DeleteMapping("/{todoID}")
    public ResponseEntity<Void> deleteTodo( @PathVariable int todoID) {
        todoService.deleteTodo(todoID);
        return ResponseEntity.noContent().build();
    }
}
