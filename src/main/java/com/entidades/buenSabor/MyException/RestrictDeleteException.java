package com.entidades.buenSabor.MyException;

public class RestrictDeleteException extends RuntimeException {
    public RestrictDeleteException(String message) {
        super(message);
    }
}
