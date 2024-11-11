package com.ssafy.sandbox.crud.service;

import com.ssafy.sandbox.crud.dto.ArticleListResponse;
import com.ssafy.sandbox.crud.dto.ArticleRequest;

import java.util.Map;

public interface ArticleService {
    void makeArticle(ArticleRequest newArticle);

    ArticleListResponse articlePaging(Map<String, String> typePaging, int pageable);
}
