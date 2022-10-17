package com.example.demo.core;


public class ResponseApi {

    private String code;
    private String message;

    public ResponseApi(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
