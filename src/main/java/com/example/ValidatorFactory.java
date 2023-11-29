package com.example;

import io.micronaut.context.annotation.Factory;
import io.micronaut.validation.validator.constraints.ConstraintValidator;
import jakarta.inject.Singleton;

/**
 * Factory class for creating {@link ConstraintValidator} beans.
 */
@Factory
public class ValidatorFactory {

    /**
     * Factory method to provide a validator for the {@link NullOrNotBlank} annotation.
     *
     * @return the validator
     */
    @Singleton
    ConstraintValidator<NullOrNotBlank, String> nullOrNotBlankStringConstraintValidator() {
        return ((value, annotationMetadata, context) ->
                value == null || !value.isBlank()
        );
    }
}
