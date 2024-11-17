package com.ssafy.sandbox.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ssafy.sandbox.crud.vo.Article;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleListResponse {
    private List<Article> articles;
    private Integer totalPage = null;
    private Integer lastId = null;
}
