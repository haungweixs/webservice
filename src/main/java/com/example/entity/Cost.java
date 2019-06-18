package com.example.entity;

import java.util.List;

/**
 * Created by LiWeijie
 * 19/03/19 17:51
 */
public class Cost {
    private   String theme;
    private   String  money;
    private   String  objectid;
    private   String  balance;
    private   String  userid;
    private   String  deptid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    private  List<Mixi>  details;

    public List<Mixi> getDetails() {
        return details;
    }

    public void setDetails(List<Mixi> details) {
        this.details = details;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
