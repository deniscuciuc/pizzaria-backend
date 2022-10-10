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
@RequestMapping("/api/post/")
public class PostController {

    private final PostService postService;

    public PostController(PostServiceImpl postServiceImpl) {
        this.postService = postServiceImpl;
    }

    @PostMapping("save")
    @ResponseStatus(CREATED)
    public Post savePost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @PutMapping("update/{id}")
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
                    .status(NOT_FOUND)
                    .body(exception.getMessage());
        }
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
