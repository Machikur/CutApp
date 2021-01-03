package com.urlcuter.cuter.linkexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongShortVersionExeption extends Exception {
    public WrongShortVersionExeption(String message) {
        super(message);
    }
}
