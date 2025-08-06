package com.day19.Student_Marks_Portal.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidScoreValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidScore {
    String message() default "Score must be a multiple of 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}