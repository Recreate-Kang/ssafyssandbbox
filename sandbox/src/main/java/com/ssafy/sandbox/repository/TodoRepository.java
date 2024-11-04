package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.vo.TodoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<TodoDto, Integer> {

    @Modifying
    @Query("UPDATE TodoDto t SET t.completed = NOT t.completed WHERE t.id = :todoId")
    void toggleTodoCompletion(@Param("todoId") int todoId);
}
