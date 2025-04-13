package com.example.projetofinal.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final int httpStatusInNumber;

    public APIException(String message, HttpStatus status) {
        super(message);
        httpStatus = status;
        httpStatusInNumber = status.value();
    }

    public APIException(HttpStatus status) {
        super("There was an internal error, please contact the support team!");
        httpStatus = status;
        httpStatusInNumber = status.value();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public int getHttpStatusInNumber() {
        return this.httpStatusInNumber;
    }
}
