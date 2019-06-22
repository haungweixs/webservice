package com.example.entity.basic;




public class Brand {


    private Integer id;


    private String chuanyunid;

    private String brandName;

    private Integer companyId;

    private String brandCode;

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChuanyunid() {
        return chuanyunid;
    }

    public void setChuanyunid(String chuanyunid) {
        this.chuanyunid = chuanyunid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
