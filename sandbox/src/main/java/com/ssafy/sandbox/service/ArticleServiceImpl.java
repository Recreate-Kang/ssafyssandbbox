package com.ssafy.sandbox.service;

import com.ssafy.sandbox.dto.ArticleListResponse;
import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.repository.ArticleRepository;
import com.ssafy.sandbox.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public void makeArticle(ArticleRequest newArticle) {
        articleRepository.saveAll(newArticle.getArticles());
    }

    @Override
    public ArticleListResponse articlePaging(Map<String, String> typePaging, int pageable) {
        int start = 0;
        if (typePaging.containsKey("page")) {
            start = pageable * Integer.parseInt(typePaging.get("page"));
        } else if(typePaging.containsKey("cursorId")) {
            start = Integer.parseInt(typePaging.get("cursorId"));
        }
        ArticleListResponse response = new ArticleListResponse();
        response.setArticles(articleRepository.findByIdGreaterThan(start, Limit.of(pageable)));
        if (typePaging.containsKey("page")) {
            response.setTotalPage((int) articleRepository.count()/pageable);
        } else if(typePaging.containsKey("cursorId") && !response.getArticles().isEmpty()) {
            response.setLastId(response.getArticles().get(response.getArticles().size() - 1).getId());
        }
        return response;
    }
}
