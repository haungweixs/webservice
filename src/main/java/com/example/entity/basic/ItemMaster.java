package com.example.entity.basic;


public class ItemMaster {
    /**
     * id
     */

    private Integer itemMasterId;

    /**
     * 货主名称
     */
    private String itemMasterName;

    /**
     * 联系人
     */
    private String linkMan;

    /**
     * 联系方式
     */
    private String linkPhone;

    /**
     * 备注
     */
    private String memo;

    /**
     * 所属公司id
     */
    private Integer companyId;

    /**
     * 创建时间
     */
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取id
     *
     * @return item_master_id - id
     */
    public Integer getItemMasterId() {
        return itemMasterId;
    }

    /**
     * 设置id
     *
     * @param itemMasterId id
     */
    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    /**
     * 获取货主名称
     *
     * @return item_master_name - 货主名称
     */
    public String getItemMasterName() {
        return itemMasterName;
    }

    /**
     * 设置货主名称
     *
     * @param itemMasterName 货主名称
     */
    public void setItemMasterName(String itemMasterName) {
        this.itemMasterName = itemMasterName;
    }

    /**
     * 获取联系人
     *
     * @return link_man - 联系人
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * 设置联系人
     *
     * @param linkMan 联系人
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    /**
     * 获取联系方式
     *
     * @return link_phone - 联系方式
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * 设置联系方式
     *
     * @param linkPhone 联系方式
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
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

    /**
     * 获取所属公司id
     *
     * @return company_id - 所属公司id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司id
     *
     * @param companyId 所属公司id
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}