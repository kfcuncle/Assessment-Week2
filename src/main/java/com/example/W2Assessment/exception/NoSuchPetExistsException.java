package com.example.W2Assessment.exception;

public class NoSuchPetExistsException extends RuntimeException{
    private String message;

    public NoSuchPetExistsException() {}

    public NoSuchPetExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
