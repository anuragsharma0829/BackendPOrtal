package com.exam.payload;

import com.exam.model.User;

import java.util.Set;

public class MsgResponse {

    private String status;
    private String message;

    private Set<User> data;

    public MsgResponse() {
    }

    public MsgResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MsgResponse(Set<User> data) {
        this.data = data;
    }

    public Set<User> getData() {
        return data;
    }

    public void setData(Set<User> data) {
        this.data =  data;
    }
}
