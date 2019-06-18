package com.example.entity.basic;


public class Pallet {
    /**
     * 托盘ID
     */

    private Integer palletId;

    /**
     * 托盘编码
     */
    private String palletCode;

    private String memo;

    private Integer palletType;


    /**
     * 托盘名字
     */
    private String palletName;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 托盘条形码编码
     */
    private String palletBarCode;

    /**
     * 货位
     */
    private String cellCode;

    public Integer getPalletId() {
        return palletId;
    }

    public void setPalletId(Integer palletId) {
        this.palletId = palletId;
    }

    public String getPalletCode() {
        return palletCode;
    }

    public void setPalletCode(String palletCode) {
        this.palletCode = palletCode;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getPalletType() {
        return palletType;
    }

    public void setPalletType(Integer palletType) {
        this.palletType = palletType;
    }

    public String getPalletName() {
        return palletName;
    }

    public void setPalletName(String palletName) {
        this.palletName = palletName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPalletBarCode() {
        return palletBarCode;
    }

    public void setPalletBarCode(String palletBarCode) {
        this.palletBarCode = palletBarCode;
    }

    public String getCellCode() {
        return cellCode;
    }

    public void setCellCode(String cellCode) {
        this.cellCode = cellCode;
    }
}