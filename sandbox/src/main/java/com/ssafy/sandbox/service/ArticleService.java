package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.vo.Article;

import java.util.List;

public interface ArticleService {
    void makeArticle(ArticleRequest newArticle);

    List<Article> articlePaging(int start, int pageable);

    Integer totalPage(int size);
}
