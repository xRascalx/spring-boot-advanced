package com.lrm.resource;

/**
 * Created by limi on 2017/8/24.
 */
public class InvalidErrorResource {

    private String message;
    private Object errors;

    public InvalidErrorResource(String message, Object errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public Object getErrors() {
        return errors;
    }
}
