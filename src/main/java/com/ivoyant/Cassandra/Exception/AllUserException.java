package com.ivoyant.Cassandra.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class AllUserException {

    private  String allUserMessage;
    private Throwable throwable;
    private  HttpStatus httpStatus;

    public AllUserException(String customErrorMessage, HttpStatus httpStatus) {
    }
}