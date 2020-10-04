package com.chea.blablacar.technicaltest.exceptions;

public class MalformedInputException extends RuntimeException {

    public MalformedInputException() {
        super();
    }

    public MalformedInputException(String message, Throwable t) {
        super(message, t);
    }

}
