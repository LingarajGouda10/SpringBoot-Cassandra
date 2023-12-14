package com.ivoyant.Cassandra.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = { UserNotFoundException.class })
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException UserNotFoundException) {


        UserException UserException = new UserException(
                "Custom error message",
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(UserException, HttpStatus.NOT_FOUND);
    }
}
