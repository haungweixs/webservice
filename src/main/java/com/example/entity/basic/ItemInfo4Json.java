package com.example.entity.basic;

/**
 * 创建4Json实体接收氚云传来参数
 */
public class ItemInfo4Json {

    private String chuanyunid;
    private String itemName;
    private String discription;
    private String memo;
    private String mainType;
    private String itemType;
    private String unit;
    private String brand;

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getChuanyunid() {
        return chuanyunid;
    }

    public void setChuanyunid(String chuanyunid) {
        this.chuanyunid = chuanyunid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
