package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.ArticleListResponse;
import com.ssafy.sandbox.dto.ArticleRequest;
import com.ssafy.sandbox.service.ArticleService;
import com.ssafy.sandbox.vo.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/paging/{type}}")
    public ResponseEntity<ArticleDto> getPagingArticle(
            @PathVariable String type,
            @RequestParam int size,
            @RequestParam Map<String,String> typePaging) {
        System.out.println("getPagingArticle" + "/size=" + size + "&page=" + typePaging);
        ArticleListResponse articles =
        if(type.equals("offset")){

        }else{

        }
        return ResponseEntity.ok().build();
    }
}
