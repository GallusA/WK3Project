package com.example.gallusawa.wk3project;

/**
 * Created by gallusawa on 8/21/17.
 */

public class SMS {
    String message, number;

    public SMS(String number, Object[] message) {
        this.number = number;
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}