package com.lrm.exception;

import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException{
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
