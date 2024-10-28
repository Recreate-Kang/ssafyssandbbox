package com.ssafy.sandbox.service;

import com.ssafy.sandbox.respository.TodoRepository;
import com.ssafy.sandbox.mapper.Todo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }


    public Todo postTodos(Todo newTodo) {
        return todoRepository.save(newTodo); // 저장 메서드 호출
    }

    @Transactional
    public void updateTodo(int todoId) {
        todoRepository.toggleTodoCompletion(todoId);
    }

    public void deleteTodo(int todoID) {
        todoRepository.deleteById(todoID);
    }
}
