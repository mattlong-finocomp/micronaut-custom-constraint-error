package com.example;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Checks that a string value is either null or contains at least one non-whitespace character.
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { })
@Target(ElementType.FIELD)
public @interface NullOrNotBlank {
    String message() default "Must be either null or contain at least one non-whitespace character";
}
