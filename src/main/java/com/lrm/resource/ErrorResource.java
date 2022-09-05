package com.lrm.resource;

/**
 * Created by limi on 2017/8/24.
 */
public class ErrorResource {
    private String message;

    public ErrorResource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
