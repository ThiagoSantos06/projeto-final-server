package com.example.projetofinal.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ExceptionDetails> APIExceptionHandler(APIException exception, HttpServletRequest request) {
        System.out.println(exception.getMessage());
        return ResponseEntity.status(exception.getHttpStatus()).body(
                new ExceptionDetails(
                        exception.getHttpStatus().toString(),
                        exception.getMessage(),
                        exception.getHttpStatusInNumber(),
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<ExceptionDetails> generalException(Exception exception, HttpServletRequest request) {
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionDetails(
                        "Internal Server Error",
                        "There was an internal error, please contact the support team!",
                        500,
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
    }

}
