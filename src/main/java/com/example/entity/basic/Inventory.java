package com.example.entity.basic;



public class Inventory {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 仓库
     */
    private String wareCode;

    /**
     * 批次ID
     */
    private Integer batchId;

    /**
     * 剩余数量
     */
    private Integer quantity;

    /**
     * 备注
     */
    private String memo;

    /**
     * 总数量
     * */
    private  Integer toalquantity;

    private  String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 在外机器数量
     * */
    private  Integer actualquantity;

    private  Integer itemmasterid;

    public Integer getItemmasterid() {
        return itemmasterid;
    }

    public void setItemmasterid(Integer itemmasterid) {
        this.itemmasterid = itemmasterid;
    }

    public Integer getToalquantity() {
        return toalquantity;
    }

    public void setToalquantity(Integer toalquantity) {
        this.toalquantity = toalquantity;
    }

    public Integer getActualquantity() {
        return actualquantity;
    }

    public void setActualquantity(Integer actualquantity) {
        this.actualquantity = actualquantity;
    }

    /**
     * 库存类型   1-审核   2-上架
     */
    private Integer type;

    /**
     * 获取仓库
     *
     * @return ware_code - 仓库
     * @param warecode
     */
    public String getWareCode(String warecode) {
        return warecode;
    }

    /**
     * 设置仓库
     *
     * @param wareCode 仓库
     */
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    /**
     * 获取数量
     *
     * @return quantity - 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置数量
     *
     * @param quantity 数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
     * 获取库存类型   1-审核   2-上架
     *
     * @return type - 库存类型   1-审核   2-上架
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置库存类型   1-审核   2-上架
     *
     * @param type 库存类型   1-审核   2-上架
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}