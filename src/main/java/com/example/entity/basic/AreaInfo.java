package com.example.entity.basic;

import java.util.Date;

public class AreaInfo {
    /**
     * 货区ID
     */
    private Integer areaId;

    /**
     * 仓库编码
     */
    private String wareCode;




    /**

     * 货区编码
     */
    private String areaCode;

    /**
     * 货区名
     */
    private String areaName;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 备注
     */
    private String memo;


    public String getAbcClass() {
        return abcClass;
    }

    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }

    /**
     * ABC分类
     */
    private String abcClass;



    /**
     * 获取货区ID
     *
     * @return area_id - 货区ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置货区ID
     *
     * @param areaId 货区ID
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取仓库编码
     *
     * @return ware_code - 仓库编码
     */
    public String getWareCode() {
        return wareCode;
    }

    /**
     * 设置仓库编码
     *
     * @param wareCode 仓库编码
     */
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    /**
     * 获取货区编码
     *
     * @return area_code - 货区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置货区编码
     *
     * @param areaCode 货区编码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取货区名
     *
     * @return area_name - 货区名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置货区名
     *
     * @param areaName 货区名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}