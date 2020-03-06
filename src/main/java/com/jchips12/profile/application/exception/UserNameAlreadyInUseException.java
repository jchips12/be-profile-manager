package com.jchips12.profile.application.exception;

public class UserNameAlreadyInUseException extends RuntimeException {
    public UserNameAlreadyInUseException(String message) {
        super(message);
    }

    public UserNameAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
