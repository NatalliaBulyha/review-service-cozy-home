package com.cozyhome.onlineshop.reviewservice.service;

import com.cozyhome.onlineshop.reviewservice.dto.ReviewAdminResponse;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewRequest;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewResponse;

import java.util.List;

public interface ReviewService {
    List<ReviewResponse> getReviews();

    ReviewResponse addNewReview(ReviewRequest review);

    List<ReviewResponse> getReviewsForProduct(String productSkuCode);

    void removeReviewById(String reviewId);

    List<ReviewAdminResponse> getReviewsForProductAllInf(String productSkuCode);
}
