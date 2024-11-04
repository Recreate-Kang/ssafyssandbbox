package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.repository.ArticleRepository;
import com.ssafy.sandbox.vo.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void makeArticle(ArticleRequest newArticle) {
        articleRepository.saveAll(newArticle.getArticles());
    }
}
