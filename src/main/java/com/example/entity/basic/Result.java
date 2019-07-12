package com.example.entity.basic;

public class Result {
    private Integer code;
    private String message;
    private ItemInfo data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ItemInfo getData() {
        return data;
    }

    public void setData(ItemInfo data) {
        this.data = data;
    }
}
