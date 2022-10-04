package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Review;
import com.stefanini.pizzariabackend.repo.ReviewRepository;
import com.stefanini.pizzariabackend.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Long deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
        return id;
    }
}
