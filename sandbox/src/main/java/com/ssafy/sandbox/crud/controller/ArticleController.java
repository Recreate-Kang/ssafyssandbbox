package com.ssafy.sandbox.crud.controller;

import com.ssafy.sandbox.crud.dto.ArticleListResponse;
import com.ssafy.sandbox.crud.dto.ArticleRequest;
import com.ssafy.sandbox.crud.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    ArticleController(ArticleService articleService){
        this.articleService =articleService;
    }

    @PostMapping("/make")
    public ResponseEntity<Void> makeAllArticle(@RequestBody ArticleRequest articles) {
        System.out.println("makeAllArticle");
        articleService.makeArticle(articles);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paging/{type}")
    public ResponseEntity<ArticleListResponse> getPagingArticle(
            @PathVariable String type,
            @RequestParam Integer size,
            @RequestParam Map<String, String> typePaging) {
        ArticleListResponse response = articleService.articlePaging(typePaging, size);
        return ResponseEntity.ok().body(response);
    }
}
