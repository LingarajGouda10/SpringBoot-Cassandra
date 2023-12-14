package com.ivoyant.Cassandra.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String User) {
        super(User);
    }

    public UserNotFoundException(String User, Throwable cause) {
        super(User, cause);
    }
}
