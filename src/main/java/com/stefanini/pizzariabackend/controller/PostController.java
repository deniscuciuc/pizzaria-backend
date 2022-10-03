package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Post;
import com.stefanini.pizzariabackend.service.PostService;
import com.stefanini.pizzariabackend.service.impl.PostServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post/")
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postService = postServiceImpl;
    }

    @PostMapping("save")
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("findAll")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(postService.deletePostById(id));
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Post with such id not found");
        }
    }
}
