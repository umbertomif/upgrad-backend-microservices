package com.sweet.home.booking.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.BindException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleValidationException(BindException ex) {
        String errorMessage = ex.getFieldError().getDefaultMessage();
        Map<String, Object> response = new HashMap<>();
        response.put("message", errorMessage);
        response.put("statusCode", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleRecordNotFound(NoSuchElementException ex) {
        String errorMessage = ex.getMessage();
        Map<String, Object> response = new HashMap<>();
        response.put("message", errorMessage);
        response.put("statusCode", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
