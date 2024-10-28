package com.ssafy.sandbox.respository;

import com.ssafy.sandbox.mapper.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAll();
    @Override
    <S extends Todo> S save(S entity); // 기본 제공 메서드
    @Modifying
    @Query("UPDATE Todo t SET t.completed = NOT t.completed WHERE t.id = :todoId")
    void toggleTodoCompletion(@Param("todoId") int todoId);

    @Modifying
    @Override
    void deleteById(Integer todoID);
}
