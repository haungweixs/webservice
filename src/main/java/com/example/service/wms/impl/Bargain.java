package com.example.service.wms.impl;

import java.math.BigDecimal;

/**
 * Created by LiWeijie
 * 19/07/03 15:59
 */
public class Bargain {
    private  String id;
    private  BigDecimal ysmoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getYsmoney() {
        return ysmoney;
    }

    public void setYsmoney(BigDecimal ysmoney) {
        this.ysmoney = ysmoney;
    }

    /**
     * 合同主题
     * */
    private  String  theme;
    /**
     * 客户信息
     * */
//    private   String  clientele;
    /**
     * 我方签约人
     * */
    private   Object  parties;
    private   Object  section;

    public Object getParties() {
        return parties;
    }

    public void setParties(Object parties) {
        this.parties = parties;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    private  String     addtime;
    private   String endtime;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }



    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getSkfs() {
        return skfs;
    }

    public void setSkfs(String skfs) {
        this.skfs = skfs;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        if (remark==null){
            this.remark = "";
        }else {
            this.remark =remark;
        }
    }

    private  String  skfs;
    private BigDecimal summoney;

    public BigDecimal getSummoney() {
        return summoney;
    }

    public void setSummoney(BigDecimal summoney) {
        this.summoney = summoney;
    }

    private  String  remark;
}
