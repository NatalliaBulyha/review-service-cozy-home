package com.cozyhome.onlineshop.reviewservice.controller;

import com.cozyhome.onlineshop.reviewservice.dto.ReviewAdminResponse;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewRequest;
import com.cozyhome.onlineshop.reviewservice.dto.ReviewResponse;
import com.cozyhome.onlineshop.reviewservice.service.ReviewService;
import com.cozyhome.onlineshop.reviewservice.validation.ValidSkuCode;
import com.cozyhome.onlineshop.reviewservice.validation.ValidUUID;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.basePath}/review")
public class ReviewControllerImpl {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> getReviews() {
        return new ResponseEntity<>(reviewService.getReviews(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ReviewResponse> addNewReview(@RequestBody @Valid ReviewRequest review) {
        return new ResponseEntity<>(reviewService.addNewReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ReviewResponse>> getReviewsForProduct(@RequestParam @ValidSkuCode String productSkuCode) {
        return new ResponseEntity<>(reviewService.getReviewsForProduct(productSkuCode), HttpStatus.OK);
    }

    @GetMapping("/admin/product")
    public ResponseEntity<List<ReviewAdminResponse>> getReviewsForProductAllInf(@RequestParam @ValidSkuCode String productSkuCode) {
        return new ResponseEntity<>(reviewService.getReviewsForProductAllInf(productSkuCode), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> removeReviewById(@RequestParam @ValidUUID String reviewId) {
        reviewService.removeReviewById(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 }
