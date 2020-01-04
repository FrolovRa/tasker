package net.frolov.exception.handler;

import org.springframework.http.HttpStatus;

public class RestException {
    private final HttpStatus status;
    private final Class exceptionClass;
    private final String message;

    RestException(HttpStatus status, Class exceptionClass, String message) {
        this.status = status;
        this.exceptionClass = exceptionClass;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Class getExceptionClass() {
        return exceptionClass;
    }

    public String getMessage() {
        return message;
    }
}
