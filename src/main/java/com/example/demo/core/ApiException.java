package com.example.demo.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException {
    Message message;

    public ApiException(Message message) {
        super(message.getMessage());
        this.message = message;
    }

}
