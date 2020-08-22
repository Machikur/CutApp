package com.urlcuter.cuter.linkexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongShortVersionExeption extends Exception {
    public WrongShortVersionExeption(String message) {
        super(message);
    }
}
