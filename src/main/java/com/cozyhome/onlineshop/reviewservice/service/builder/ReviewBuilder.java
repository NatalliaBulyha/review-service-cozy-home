package com.cozyhome.onlineshop.reviewservice.service.builder;

import com.cozyhome.onlineshop.reviewservice.dto.ReviewResponse;
import com.cozyhome.onlineshop.reviewservice.model.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewBuilder {
    public List<ReviewResponse> buildReviewsResponse(List<Review> reviews) {
        return reviews.stream().map(this::buildReviewResponse).toList();
    }

    public ReviewResponse buildReviewResponse(Review review) {
            return ReviewResponse.builder()
                    .rating((byte) review.getRating())
                    .userName(review.getUserName())
                    .review(review.getComment())
                    .data(review.getModifiedAt().toLocalDate())
                    .build();
    }
}
