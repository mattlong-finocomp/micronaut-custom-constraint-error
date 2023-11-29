package com.example


import io.micronaut.test.extensions.spock.annotation.MicronautTest
import io.micronaut.validation.validator.Validator
import jakarta.inject.Inject
import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import spock.lang.Specification

@MicronautTest
class CustomConstraintErrorSpec extends Specification {

    @Inject
    Validator validator

    @Inject MyEntityRepository myEntityRepository

    void 'calling validator directly works'() {
        given:
        MyEntity entity = new MyEntity()
        entity.setName(" ")

        when:
        Set<ConstraintViolation<?>> violations = validator.validateProperty(entity, "name")

        then:
        violations.size() == 1
    }

    void "validator called from hibernate dies"() {
        given:
        MyEntity entity = new MyEntity()
        entity.setName(" ")

        when:
        myEntityRepository.saveAndFlush(entity)

        then:
        thrown(ConstraintViolationException) // we get an UnexpectedTypeException instead because the constraint validator isn't found
    }
}
