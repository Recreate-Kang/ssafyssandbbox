package com.ssafy.sandbox.crud.dto;

import com.ssafy.sandbox.crud.vo.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticleRequest {
    private List<Article> articles;
}
