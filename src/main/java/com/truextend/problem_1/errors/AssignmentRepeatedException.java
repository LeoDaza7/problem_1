package com.truextend.problem_1.errors;

import lombok.Getter;

@Getter
public class AssignmentRepeatedException extends Exception {

    private int responseCode;

    public AssignmentRepeatedException(String message) {
        super(message + " are already assigned.");
        this.responseCode = 404;
    }

}
