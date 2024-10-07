package com.hritam.CarServiceAgency.Json;

public class ErrorJson {

    private String message;
    private int code;
    public ErrorJson() {}


    public ErrorJson(String message, int code) {
        this.message = message;
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
