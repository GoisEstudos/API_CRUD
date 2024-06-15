package com.bielsoft.locadoraSpring.exceptions;

public abstract class ExceptionAbstrata extends RuntimeException {
    public ExceptionAbstrata(String message) {
        super(message);
    }

    public ExceptionAbstrata(String message, Throwable cause) {
        super(message, cause);
    }
}
