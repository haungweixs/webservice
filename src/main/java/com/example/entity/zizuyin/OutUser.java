package com.example.entity.zizuyin;

/**
 * Created by LiWeijie
 * 19/08/15 14:24
 */
public class OutUser {
    /**	服务商名*/
    private  String  merchantName;
    /**用户名*/
    private  String  username;
    /**密码 (直接传密码，https协议有自带加密)*/
    private  String  pwd;
    /**公司名*/
    private  String  companyName;
    /**电话*/
    private  String mobile;
    /**用户id*/
    private  String  userId;
    /**地址*/
    private  String address;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
