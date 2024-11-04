package com.ssafy.sandbox.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Table(name="article")
public class ArticleDto {

    @Id
    @Column(name = "ID", columnDefinition = "AUTO_INCREMENT")
    private int id;
    @Setter
    @Column(name ="ARTICLE", columnDefinition = "NOT NULL")
    private String title;
    @Column(name ="CREATED_AT", columnDefinition = "DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime createdAt;
}
