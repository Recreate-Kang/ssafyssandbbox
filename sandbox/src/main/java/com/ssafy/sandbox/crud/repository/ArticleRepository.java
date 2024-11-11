package com.ssafy.sandbox.crud.repository;

import com.ssafy.sandbox.crud.vo.Article;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByIdGreaterThan(int start, Limit pageable);

    long count();
}