package com.cozyhome.onlineshop.reviewservice.service;

import com.cozyhome.onlineshop.reviewservice.dto.ReviewAdminResponse;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewRequest;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewResponse;
import com.cozyhome.onlineshop.reviewservice.handler.DataNotExistException;
import com.cozyhome.onlineshop.reviewservice.handler.DataNotFoundException;
import com.cozyhome.onlineshop.reviewservice.model.Review;
import com.cozyhome.onlineshop.reviewservice.repository.ReviewRepository;
import com.cozyhome.onlineshop.reviewservice.service.builder.ReviewBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository repository;
    private final ModelMapper mapper;
    private final ReviewBuilder reviewBuilder;
    @Override
    public List<ReviewResponse> getReviews() {
        List<Review> reviews = repository.findAll();
        if (reviews.isEmpty()) {
            throw new DataNotFoundException("The are no reviews.");
        }
        return reviews.stream().map(review -> mapper.map(review, ReviewResponse.class)).toList();
    }

    @Override
    public ReviewResponse addNewReview(ReviewRequest reviewRequest) {
        Review review = mapper.map(reviewRequest, Review.class);
        review.setCreatedAt(LocalDateTime.now());
        review.setModifiedAt(LocalDateTime.now());
        Review savedReview = repository.save(review);
        return ReviewResponse.builder()
                .data(savedReview.getModifiedAt().toLocalDate())
                .review(savedReview.getComment())
                .userName(savedReview.getUserName())
                .rating((byte) savedReview.getRating())
                .build();
    }

    @Override
    public List<ReviewResponse> getReviewsForProduct(String productSkuCode) {
        List<Review> reviews = repository.findReviewsByProductSkuCode(productSkuCode);
        if (reviews.isEmpty()) {
            return new ArrayList<>();
        }
        return reviewBuilder.buildReviewsResponse(reviews);
    }

    @Override
    public void removeReviewById(String reviewId) {
        boolean exist = repository.existsById(UUID.fromString(reviewId));
        if (exist) {
            repository.deleteById(UUID.fromString(reviewId));
        } else {
            throw new DataNotExistException("Review with id = " + reviewId + " isn't exist.");
        }
    }

    @Override
    public List<ReviewAdminResponse> getReviewsForProductAllInf(String productSkuCode) {
        List<Review> reviews = repository.findReviewsByProductSkuCode(productSkuCode);
        if (reviews.isEmpty()) {
            throw new DataNotExistException("Review for product with sku code = " + productSkuCode + " isn't exist.");
        }
        return reviews.stream().map(review -> mapper.map(review, ReviewAdminResponse.class)).toList();
    }
}
