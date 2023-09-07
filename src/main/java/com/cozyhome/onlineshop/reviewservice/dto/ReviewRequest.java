package com.cozyhome.onlineshop.reviewservice.dto;

import com.cozyhome.onlineshop.reviewservice.validation.ValidSkuCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewRequest {
    @Max(value = 5, message = "value must be between 1 and 5.")
    @Min(value = 1, message = "value must be between 1 and 5.")
    private byte rating;
    @Size(max = 500, message = "comment must be to 500 characters.")
    private String comment;
    @Size(max = 50, message = "name must be to 50 characters.")
    private String userName;
    @ValidSkuCode
    private String productSkuCode;
}
