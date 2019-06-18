package com.example.entity.user;

/**
 * Created by LiWeijie
 * 19/04/11 13:45
 */
public class Userinfo
{
    private double  code;
    private  String message;
    private User data;

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
