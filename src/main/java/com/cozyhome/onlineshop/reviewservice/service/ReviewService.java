package com.cozyhome.onlineshop.reviewservice.service;

import com.cozyhome.onlineshop.reviewservice.dto.ReviewDto;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewRequest;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getReviews();

    ReviewResponse saveReview(ReviewRequest review);

    List<ReviewResponse> getReviewsForProduct(String productSkuCode);

    void removeReviewById(String reviewId);

    List<ReviewDto> getReviewsForProductAllInf(String productSkuCode);
}
