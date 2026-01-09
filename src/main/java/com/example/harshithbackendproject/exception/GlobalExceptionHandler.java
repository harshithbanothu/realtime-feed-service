package com.example.harshithbackendproject.exception;

import com.example.harshithbackendproject.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(ApiException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ApiResponse.fail(ex.getMessage()));
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<ApiResponse<Object>> handleTimeout(SocketTimeoutException ex) {
        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT.value())
                .body(ApiResponse.fail("Upstream API timed out"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(ApiResponse.fail("Internal server error"));
    }
}