package com.folksdev.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundExcepiton extends RuntimeException{
    public CustomerNotFoundExcepiton(String message){
        super(message);
    }
}
