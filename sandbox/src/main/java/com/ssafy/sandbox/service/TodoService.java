package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.TodoDto;
import com.ssafy.sandbox.respository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll();
    }
    public TodoDto createTodos(TodoDto newTodoDto) {
        return todoRepository.save(newTodoDto); // 저장 메서드 호출
    }
    @Transactional
    public void toggleTodo(int todoId) {
        todoRepository.toggleTodoCompletion(todoId);
    }
    public void deleteTodo(int todoID) {
        todoRepository.deleteById(todoID);
    }
}
