package com.omkar.exception;

public class CarAlreadyExistException extends RuntimeException {
    public CarAlreadyExistException(String message) {
        super(message);
    }
}
