package com.example.entity.basic;


public class ItemInfo {
    private Integer id;

    private String chuanyunid;

    private String brand;

    private String mainType;

    private String discription;

    private String itemType;

    private String unit;

    /**
     * 物料类型编码
     */
    private String itemTypeCode;

    /**
     * 上限
     */
    private Integer upperLimit;

    /**
     * 下限
     */
    private Integer floorLimit;

    /**
     * 备注
     */
    private String memo;
    /**
     * 公司ID
     */
    private  Integer companyId;


    /**
     * ABC分类
     */
    private String  abcClass;



    public String getChuanyunid() {
        return chuanyunid;
    }

    public void setChuanyunid(String chuanyunid) {
        this.chuanyunid = chuanyunid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        if(mainType!=null){
            this.mainType = mainType;
        }else{
            mainType="123";
        }


    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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

    private String itemCode;

    /** batch
     * 条形码编码
     */
    private String itemBarCode;



    /**
     * 批次
     */
    private String batch;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * 物料名称
     */
    private String itemName;

    /**
     * 物料规格
     */
    private String itemClass;

    /**
     * 单价
     */
    private Double defaultPrice;

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * d单位
     */
    private String unitCode;

    /**
     * 重量
     */
    private String weight;

    /**
     * 供应商编码
     */
    private String supplierCode;


    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**

     * 客户编码
     */
    private String clientCode;
    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        if(clientCode!=null){
            this.clientCode = clientCode;
        }else{
            clientCode="123456";
        }


    }
    /**
     * 内部编码
     */
    private String internalCode;
    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        if(internalCode !=null){
            this.internalCode = internalCode;
        }else{
            internalCode="123456";
        }
    }






    public String getAbcClass() {
        return abcClass;
    }

    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return item_code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取条形码编码
     *
     * @return item_bar_code - 条形码编码
     */
    public String getItemBarCode() {
        return itemBarCode;
    }

    /**
     * 设置条形码编码
     *
     * @param itemBarCode 条形码编码
     */
    public void setItemBarCode(String itemBarCode) {
        this.itemBarCode = itemBarCode;
    }

    /**
     * 获取物料名称
     *
     * @return item_name - 物料名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置物料名称
     *
     * @param itemName 物料名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取物料类别
     *
     * @return item_class - 物料类别
     */
    public String getItemClass() {
        return itemClass;
    }

    /**
     * 设置物料类别
     *
     * @param itemClass 物料类别
     */
    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    /**
     * 获取物料规格
     *
     * @return item_type_code - 物料规格
     */
    public String getItemTypeCode() {
        return itemTypeCode;
    }

    /**
     * 设置物料规格
     *
     * @param itemTypeCode 物料规格
     */
    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    /**
     * 获取上限
     *
     * @return upper_limit - 上限
     */
    public Integer getUpperLimit() {
        return upperLimit;
    }

    /**
     * 设置上限
     *
     * @param upperLimit 上限
     */
    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * 获取下限
     *
     * @return floor_limit - 下限
     */
    public Integer getFloorLimit() {
        return floorLimit;
    }

    /**
     * 设置下限
     *
     * @param floorLimit 下限
     */
    public void setFloorLimit(Integer floorLimit) {
        this.floorLimit = floorLimit;
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