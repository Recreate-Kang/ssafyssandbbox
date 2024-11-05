package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.vo.ArticleDto;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleDto, Integer> {
    List<ArticleDto> findByIdGreaterThan(int start, Limit pageable);

    long count();
}
