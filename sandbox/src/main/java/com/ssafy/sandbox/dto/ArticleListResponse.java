package com.ssafy.sandbox.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.sandbox.vo.Article;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleListResponse {
    private List<Article> articles;
    private int totalPage;
    private int lastId;
}
