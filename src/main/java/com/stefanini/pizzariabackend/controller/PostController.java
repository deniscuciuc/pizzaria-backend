package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Post;
import com.stefanini.pizzariabackend.service.PostService;
import com.stefanini.pizzariabackend.service.impl.PostServiceImpl;
import com.stefanini.pizzariabackend.service.impl.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postService = postServiceImpl;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(
            @PathVariable Long id,
            @RequestBody Post newPost
    ) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(postService.updatePost(id, newPost));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(exception.getResponseStatus())
                    .body(exception.getMessage());
        }
    }

    @GetMapping
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(postService.deletePostById(id));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(exception.getResponseStatus())
                    .body(exception.getMessage());
        }
    }
}
