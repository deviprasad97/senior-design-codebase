package com.example.myapplication;

public class LoginResponse {
    private String auth_token;
    private String message;
    private String status;
    private User user;


    public LoginResponse(String auth_token, String message, String  status, User user) {
        this.auth_token = auth_token;
        this.message = message;
        this.status = status;
        this.user=user;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
    public User getUser(){
        return user;
    }
}
