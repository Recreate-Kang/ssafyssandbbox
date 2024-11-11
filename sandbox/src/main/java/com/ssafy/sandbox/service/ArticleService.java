package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.ArticleListResponse;
import com.ssafy.sandbox.dto.ArticleRequest;

import java.util.Map;

public interface ArticleService {
    void makeArticle(ArticleRequest newArticle);

    ArticleListResponse articlePaging(Map<String, String> typePaging, int pageable);
}
