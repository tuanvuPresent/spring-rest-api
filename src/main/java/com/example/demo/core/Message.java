package com.example.demo.core;

public enum Message {
    NOT_FOUND("1004", "Not found");

    private final String code;
    private final String message;

    private Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
