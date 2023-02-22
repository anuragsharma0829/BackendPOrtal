package com.exam.payload;

import com.exam.model.User;

public class ApiResponse {

    private String message;
    private boolean success;
    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ApiResponse(String message, boolean success, User user) {
        this.message = message;
        this.success = success;
        this.user = user;
    }

    public ApiResponse() {
    }
}
