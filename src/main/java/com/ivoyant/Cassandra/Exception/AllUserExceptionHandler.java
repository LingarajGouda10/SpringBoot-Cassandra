package com.ivoyant.Cassandra.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllUserExceptionHandler {

    @ExceptionHandler(value = { AllUserNotFoundException.class })
    public ResponseEntity<Object> handleAllUserNotFoundException(
            AllUserNotFoundException allUserNotFoundException) {


        AllUserException allUserException = new AllUserException(
                "Custom error message",
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(allUserException, HttpStatus.NOT_FOUND);
    }
}