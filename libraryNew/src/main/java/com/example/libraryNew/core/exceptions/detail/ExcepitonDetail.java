package com.example.libraryNew.core.exceptions.detail;

public class ExcepitonDetail {

    private String message;

    public ExcepitonDetail() {
    }

    public ExcepitonDetail(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
