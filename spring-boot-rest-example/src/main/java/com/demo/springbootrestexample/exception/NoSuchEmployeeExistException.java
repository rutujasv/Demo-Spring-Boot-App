package com.demo.springbootrestexample.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NoSuchEmployeeExistException extends RuntimeException {
    private String message;
    public NoSuchEmployeeExistException(String message) {
        super(message);
        this.message = message;
    }
    public NoSuchEmployeeExistException() {
    }
}
