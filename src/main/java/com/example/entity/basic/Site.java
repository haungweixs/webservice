package com.example.entity.basic;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by LiWeijie
 * 19/11/25 17:19
 */
public class Site {
    private  String adcode;
    private  String adname;

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    @JsonProperty("Detail")
    public   String Detail;

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
