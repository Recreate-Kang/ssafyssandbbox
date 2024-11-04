package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.vo.ArticleDto;
import lombok.Data;

import java.util.List;

@Data
public class ArticleListResponse {
    private List<ArticleDto> articles;
}
