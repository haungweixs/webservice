package com.example.entity.Theants;

/**
 * Created by LiWeijie
 * 19/09/23 15:22
 */
public class NotaryTrans {
    String accountId;
    Integer bizId;
    String subBizId;
    String customer;
    String trustee;
    String properties;
    String timestamp;
    String signedData;
    boolean tsr;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public String getSubBizId() {
        return subBizId;
    }

    public void setSubBizId(String subBizId) {
        this.subBizId = subBizId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTrustee() {
        return trustee;
    }

    public void setTrustee(String trustee) {
        this.trustee = trustee;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignedData() {
        return signedData;
    }

    public void setSignedData(String signedData) {
        this.signedData = signedData;
    }

    public boolean isTsr() {
        return tsr;
    }

    public void setTsr(boolean tsr) {
        this.tsr = tsr;
    }
}
