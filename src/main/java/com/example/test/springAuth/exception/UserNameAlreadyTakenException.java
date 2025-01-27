package com.example.test.springAuth.exception;

public class UserNameAlreadyTakenException extends RuntimeException {
    public UserNameAlreadyTakenException(String message) {
        super(message);
    }
}
