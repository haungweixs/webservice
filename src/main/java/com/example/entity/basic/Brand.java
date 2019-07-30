package com.example.entity.basic;




public class Brand {


    private Integer id;


    private String chuanyunId;

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

    public String getChuanyunId() {
        return chuanyunId;
    }

    public void setChuanyunId(String chuanyunid) {
        this.chuanyunId = chuanyunid;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
