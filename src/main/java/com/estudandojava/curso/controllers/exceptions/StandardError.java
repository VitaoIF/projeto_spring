package com.estudandojava.curso.controllers.exceptions;

import java.time.Instant;

public class StandardError extends RuntimeException {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

    public StandardError(){}

    public StandardError(String message) {
        super(message);
    }

    public StandardError(String message1, String path, Integer status, Instant timestamp) {
        super();
        this.message = message1;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
