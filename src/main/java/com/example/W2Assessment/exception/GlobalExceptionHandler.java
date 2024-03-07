package com.example.W2Assessment.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message}")
    private String message;

    @ExceptionHandler(value = NoSuchPetExistsException.class)
    public ResponseEntity noSuchPetExistsException(NoSuchPetExistsException noSuchPetExistsException) {
        return new ResponseEntity(message, HttpStatus.NOT_FOUND);
    }
}
