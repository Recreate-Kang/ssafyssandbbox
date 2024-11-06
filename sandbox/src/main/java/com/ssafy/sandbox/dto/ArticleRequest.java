package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.vo.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticleRequest {
    private List<Article> articles;
}
