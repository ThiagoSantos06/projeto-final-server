package com.example.projetofinal.exception;

public record ExceptionDetails(
        String title,
        String message,
        int status,
        String timestamp,
        String path,
        String method
) {}
