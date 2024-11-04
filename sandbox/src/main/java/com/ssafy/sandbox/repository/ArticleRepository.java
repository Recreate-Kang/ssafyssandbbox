package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.vo.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleDto, Integer> {

}
