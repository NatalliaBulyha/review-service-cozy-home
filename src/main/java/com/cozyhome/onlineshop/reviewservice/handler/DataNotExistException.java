package com.cozyhome.onlineshop.reviewservice.handler;

public class DataNotExistException extends RuntimeException {

    public DataNotExistException(String message) {
        super(message);
    }
}
