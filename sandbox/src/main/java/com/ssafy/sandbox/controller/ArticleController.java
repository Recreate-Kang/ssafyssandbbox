package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.ArticleListResponse;
import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.service.ArticleService;
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
        System.out.println("getPagingArticle" + "/size=" + size + "&page=" + typePaging);
        int start;
        if (type.equals("offset")) {
            start = size * Integer.parseInt(typePaging.get("page"));
        } else {
            start = Integer.parseInt(typePaging.get("cursorId"));

        }
        ArticleListResponse response = new ArticleListResponse();
        response.setArticles(articleService.articlePaging(start, size));
        if (type.equals("offset")) {
            response.setTotalPage(articleService.totalPage(size));
        } else if (type.equals("cursor") && !response.getArticles().isEmpty()) {
            response.setLastId(response.getArticles().get(response.getArticles().size() - 1).getId());
        }
        return ResponseEntity.ok().body(response);
    }
}
