package com.cozyhome.onlineshop.reviewservice.validation;

import com.cozyhome.onlineshop.reviewservice.validation.impl.SkuCodeConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SkuCodeConstraintValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RUNTIME)
public @interface ValidSkuCode {
    String message() default "Invalid SkuCode. SkuCode must be 6 numbers.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
