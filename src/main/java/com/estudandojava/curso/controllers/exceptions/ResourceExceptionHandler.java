package com.estudandojava.curso.controllers.exceptions;

import com.estudandojava.curso.services.exceptions.DatabaseException;
import com.estudandojava.curso.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(e.getMessage(), request.getRequestURI(), status.value(), Instant.now());
        return ResponseEntity.status(status).body(err);
    }
    public ResourceExceptionHandler(String message) {
        super(message);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(e.getMessage(), request.getRequestURI(), status.value(), Instant.now());
        return ResponseEntity.status(status).body(err);
    }
}
