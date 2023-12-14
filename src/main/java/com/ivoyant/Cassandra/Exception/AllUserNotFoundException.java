package com.ivoyant.Cassandra.Exception;

public class AllUserNotFoundException extends RuntimeException {

    public AllUserNotFoundException(String allUser) {
        super(allUser);
    }

    public AllUserNotFoundException(String allUser, Throwable cause) {
        super(allUser, cause);
    }
}