package com.example.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by LiWeijie
 * 19/11/15 10:57
 */
public class BizObject {
    @JsonProperty("BizObjectId")
    public   String BizObjectId;

    public String getBizObjectId() {
        return BizObjectId;
    }

    public void setBizObjectId(String bizObjectId) {
        this.BizObjectId = bizObjectId;
    }
}
