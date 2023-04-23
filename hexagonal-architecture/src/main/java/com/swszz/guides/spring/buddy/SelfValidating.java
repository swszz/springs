package com.swszz.guides.spring.buddy;

import jakarta.validation.*;

import java.util.Set;

/**
 * @author : swszz
 */
public abstract class SelfValidating<T> {

    private final Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 각 필드에 대한 유효성 검증을 수행한다.
     */
    protected void validateSelf() {
        final Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
