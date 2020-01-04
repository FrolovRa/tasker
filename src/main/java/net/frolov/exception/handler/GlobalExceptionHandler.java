package net.frolov.exception.handler;

import lombok.val;
import net.frolov.exception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        if (ex instanceof EntityNotFoundException) {
            val errorInfo = new RestException(HttpStatus.NOT_FOUND, ex.getClass(), ex.getMessage());
            return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else if (ex instanceof MethodArgumentTypeMismatchException) {
            val errorInfo = new RestException(HttpStatus.BAD_REQUEST, ex.getClass(), ex.getMessage());
            return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        } else {
            val errorInfo = new RestException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getClass(), ex.getMessage());
            return new ResponseEntity<>(errorInfo, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
