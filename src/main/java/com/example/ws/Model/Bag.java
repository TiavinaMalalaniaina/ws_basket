package com.example.ws.Model;

public class Bag {

    String exception;
    Object data;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Bag(String exception, Object data) {
        this.setException(exception);
        this.setData(data);
    }
}
