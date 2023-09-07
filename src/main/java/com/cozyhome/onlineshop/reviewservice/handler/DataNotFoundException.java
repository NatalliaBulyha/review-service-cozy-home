package com.cozyhome.onlineshop.reviewservice.handler;

public class DataNotFoundException extends RuntimeException {
	
    public DataNotFoundException(String message) {
        super(message);
    }
}
