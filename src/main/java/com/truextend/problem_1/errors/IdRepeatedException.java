package com.truextend.problem_1.errors;

import lombok.Getter;

@Getter
public class IdRepeatedException extends Exception {

    private int responseCode;

    public IdRepeatedException(String message) {
        super(message + " is already register.");
        this.responseCode = 409;
    }

}
