package com.example.util;

import java.util.Date;

/**
 * Created by LiWeijie
 * 19/11/08 17:55
 */
public class Baodan {
    private  String MainId; //订单编号
    private  String Seller;   //商家名称(由 PICC 分配 ID)
    private  String ExchangeNo;  //PICC 缴费通知单号
    private  String txHash;
    private  String AlipayId;
    private  Integer Premium;
    private  String PayTime;

    public String getMainId() {
        return MainId;
    }

    public void setMainId(String mainId) {
        MainId = mainId;
    }

    public String getSeller() {
        return Seller;
    }

    public void setSeller(String seller) {
        Seller = seller;
    }

    public String getExchangeNo() {
        return ExchangeNo;
    }

    public void setExchangeNo(String exchangeNo) {
        ExchangeNo = exchangeNo;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getAlipayId() {
        return AlipayId;
    }

    public void setAlipayId(String alipayId) {
        AlipayId = alipayId;
    }

    public Integer getPremium() {
        return Premium;
    }

    public void setPremium(Integer premium) {
        Premium = premium;
    }

    public String getPayTime() {
        return PayTime;
    }

    public void setPayTime(String payTime) {
        PayTime = payTime;
    }
}
