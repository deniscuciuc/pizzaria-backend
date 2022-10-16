package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Review;
import com.stefanini.pizzariabackend.service.ReviewService;
import com.stefanini.pizzariabackend.service.impl.ReviewServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewService = reviewServiceImpl;
    }

    @PostMapping
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping
    public List<Review> findAllReviews() {
        return reviewService.findAllReviews();
    }

    @DeleteMapping("/{id}")
    public Long deleteReviewById(@PathVariable Long id) {
        return reviewService.deleteReviewById(id);
    }
}
