package com.ssafy.sandbox.respository;

import com.ssafy.sandbox.dto.TodoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoDto, Integer> {

    @Modifying
    @Query("UPDATE TodoDto t SET t.completed = NOT t.completed WHERE t.id = :todoId")
    void toggleTodoCompletion(@Param("todoId") int todoId);
}
