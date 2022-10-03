package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Post;
import com.stefanini.pizzariabackend.repo.PostRepository;
import com.stefanini.pizzariabackend.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Long deletePostById(Long id) {
        postRepository.deleteById(id);
        return id;
    }
}
