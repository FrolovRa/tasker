package net.frolov.exception.handler;

import lombok.val;
import net.frolov.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        if (ex instanceof EntityNotFoundException) {
            val errorInfo = new RestException(HttpStatus.NOT_FOUND, ex.getClass(), ex.getMessage());
            return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else {
            val errorInfo = new RestException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getClass(), ex.getMessage());
            return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
