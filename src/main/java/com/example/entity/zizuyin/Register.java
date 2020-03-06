package com.example.entity.zizuyin;

/**
 * Created by LiWeijie
 * 19/08/12 9:33
 */
public class Register {

    /**服务商名*/
    private  String name;
    /**手机号(即登录账号)*/
    private  String mobile;
    /**密码 (直接传密码，https协议有自带加密)*/
    private  String pwd;
    /**nb数据回调地址*/
    private  String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String[] args) {

    }
}
