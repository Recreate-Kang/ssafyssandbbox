package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.service.ArticleService;
import com.ssafy.sandbox.vo.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/make")
    public ResponseEntity<Void> makeAllArticle(@RequestBody ArticleRequest articles) {
        System.out.println("makeAllArticle");
        articleService.makeArticle(articles);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paging/{type}")
    public ResponseEntity<Map<String, Object>> getPagingArticle(
            @PathVariable String type,
            @RequestParam Integer size,
            @RequestParam Map<String, String> typePaging) {
        //System.out.println("getPagingArticle" + "/size=" + size + "&page=" + typePaging);
        int start;
        Map<String, Object> response = new HashMap<>();
        if (type.equals("offset")) {
            start = size * Integer.parseInt(typePaging.get("page"));
        } else {
            start = Integer.parseInt(typePaging.get("cursorId"));
        }
        List<ArticleDto> articleList = articleService.articlePaging(start, size);
        if (type.equals("offset")) {
            response.put("totalPage", articleService.totalPage(size));
        } else if (type.equals("cursor") && !articleList.isEmpty()) {
            response.put("lastId", articleList.get(articleList.size() - 1).getId());
        }
        response.put("articles", articleList);
        return ResponseEntity.ok().body(response);
    }
}
