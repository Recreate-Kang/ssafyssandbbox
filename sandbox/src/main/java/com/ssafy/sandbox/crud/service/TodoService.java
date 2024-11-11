package com.ssafy.sandbox.crud.service;

import com.ssafy.sandbox.crud.vo.Todo;
import com.ssafy.sandbox.crud.dto.TodoListResponse;
import com.ssafy.sandbox.crud.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    public TodoListResponse getAllTodos() {
        return new TodoListResponse(todoRepository.findAll());
    }
    public Todo createTodos(Todo newTodoDto) {
        newTodoDto.setUserId(1); // 사용자 ID 설정 (예시)
        return todoRepository.save(newTodoDto); // 저장 메서드 호출
    }
    @Transactional
    public Map<String, Boolean> toggleTodo(int todoId) {
        todoRepository.toggleTodoCompletion(todoId);
        return Map.of("complete", Boolean.TRUE);
    }
    public void deleteTodo(int todoID) {
        todoRepository.deleteById(todoID);
    }
}
