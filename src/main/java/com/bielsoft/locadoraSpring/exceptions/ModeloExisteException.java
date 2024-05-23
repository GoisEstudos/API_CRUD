package com.bielsoft.locadoraSpring.exceptions;

public class ModeloExisteException extends RuntimeException{
    public ModeloExisteException(String message) {
        super(message);
    }
}
