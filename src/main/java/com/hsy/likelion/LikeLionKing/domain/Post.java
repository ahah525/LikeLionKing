package com.hsy.likelion.LikeLionKing.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Long id;        // 게시글 id
    private String title;   // 게시글 제목
    private String content; // 게시글 내용
}
