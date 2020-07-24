package com.truextend.problem_1.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> idNotFound(IdNotFoundException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.resolve(exception.getResponseCode()));
    }

    @ExceptionHandler(IdRepeatedException.class)
    public ResponseEntity<?> idRepeated(IdRepeatedException exception, WebRequest webRequest) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.resolve(exception.getResponseCode()));
    }

}
