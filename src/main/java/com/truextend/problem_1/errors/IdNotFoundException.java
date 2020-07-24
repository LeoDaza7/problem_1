package com.truextend.problem_1.errors;

import lombok.Getter;

@Getter
public class IdNotFoundException extends Exception {

    private int responseCode;

    public IdNotFoundException(String message) {
        super(message + " is not found.");
        this.responseCode = 404;
    }

}
