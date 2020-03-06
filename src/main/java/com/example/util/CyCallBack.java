package com.example.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


/**
 * Created by LiWeijie
 *  氚云新增消息回调
 * 19/11/15 10:55
 */
public class CyCallBack implements Serializable {
    /**
     * 返回结果是否成功true/false
     * */
    @JsonProperty("Successful")
    public   Boolean  Successful;

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean Successful) {
        this.Successful = Successful;
    }

    @JsonProperty("ErrorMessage")
    /**错误信息*/
    public  String  ErrorMessage;
    @JsonProperty("Logined")
    public   Boolean  Logined;

    /**
     * 返回的数据
     * */
     @JsonProperty("ReturnData")
     public  BizObject ReturnData;

    @JsonProperty("DataType")
    public  Integer DataType;

    public BizObject getReturnData() {
        return ReturnData;
    }

    public void setReturnData(BizObject returnData) {
        ReturnData = returnData;
    }

    public Integer getDataType() {
        return DataType;
    }

    public void setDataType(Integer dataType) {
        DataType = dataType;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public Boolean getLogined() {
        return Logined;
    }

    public void setLogined(Boolean logined) {
        Logined = logined;
    }
}
