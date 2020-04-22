package com.example.pojo.validator;

import com.example.pojo.model.ErrorMessagePojo;

public class ConstraintViolationException extends RuntimeException {
    private ErrorMessagePojo errorMessagePojo;

    public ConstraintViolationException(final ErrorMessagePojo errorMessagePojo) {
        super();
        this.errorMessagePojo = errorMessagePojo;
    }
}
