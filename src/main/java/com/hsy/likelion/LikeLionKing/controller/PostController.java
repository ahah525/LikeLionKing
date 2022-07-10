package com.hsy.likelion.LikeLionKing.controller;

import com.hsy.likelion.LikeLionKing.domain.Post;
import com.hsy.likelion.LikeLionKing.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// @RestController = @Controller + @ResponseBody
// Controller로 데이터 반환하기(JSON 형태의 객체 데이터반환에 주로 사용)
@RestController
@RequiredArgsConstructor    // 생성자 주입
public class PostController {
    private final PostRepository postRepository;

    @PostMapping("/usr/article/doWrite")
    public ResponseEntity<Post> createPost(@RequestParam("title")String title, @RequestParam("content")String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.save(post));
    }

    @GetMapping("/usr/article/detail")
    public ResponseEntity<Optional<Post>> getDetailPost(@RequestParam("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findById(id));
    }

    @GetMapping("usr/article")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll());
    }

    @GetMapping("usr/article/doModify")
    public String modifyPost(@RequestParam("id")Long id, @RequestParam("title")String title, @RequestParam("content")String content) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        postRepository.update(post);
        return title;
    }

    @DeleteMapping("usr/article/{postId}")
    public Long deletePost(@PathVariable("postId") Long postId) {
        postRepository.delete(postId);
        return postId;
    }
}
