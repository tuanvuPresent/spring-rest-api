package com.example.demo.core;


public class ResponseApi {

    private boolean status;
    private String message;
    private String code;
    private Object data;

    public ResponseApi(String message, String code) {
        this.status = false;
        this.message = message;
        this.code = code;
        this.data = null;
    }

    public ResponseApi(Object data) {
        this.status = true;
        this.message = "success";
        this.code = "0000";
        this.data = data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }
}
