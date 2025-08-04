package com.day19.Student_Marks_Portal.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipleOfFiveValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleOfFive {
    String message() default "Score must be a multiple of 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}