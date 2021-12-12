package com.matrix.exception;

public class NonUniqueEmailException extends CannotCreateUserException {
    public NonUniqueEmailException(String message) {
        super(message);
    }
}
