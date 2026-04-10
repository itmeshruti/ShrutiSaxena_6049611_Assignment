package com.example.demo.exception;



public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {

    public MobileNumberDoesNotExistsForEmployeeException(String message) {
        super(message);
    }
}