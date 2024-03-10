package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class Article {
    @Id//이 필드가 대표키임을 알려줌
    //@GeneratedValue : 대표키가 1씩 자동 증가하도록 설정
    //(strategy = GenerationType.IDENTITY) : 데이터를 생설할 때마다 db가 알아서 id 값을 1씩 증가하도록 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String content;


    // null이
    public void patch(Article article) {
        if (article.title != null) {
            this.title=article.title;
        }
        if (article.content != null) {
            this.content=article.content;
        }
    }
}
