package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.repository.ArticleRepository;
import com.ssafy.sandbox.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void makeArticle(ArticleRequest newArticle) {
        articleRepository.saveAll(newArticle.getArticles());
    }

    @Override
    public List<Article> articlePaging(int start, int pageable) {
        return articleRepository.findByIdGreaterThan(start, Limit.of(pageable));
    }

    @Override
    public Integer totalPage(int size) {
        return ((int) (articleRepository.count() / size));
    }
}
