package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.mapper.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAll();
    @Override
    <S extends Todo> S save(S entity); // 기본 제공 메서드
}
