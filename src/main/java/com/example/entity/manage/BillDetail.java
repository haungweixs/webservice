package com.example.entity.manage;

public class BillDetail {
    private Integer id;
    private String detailNo;
    private String billNo;
    private String batch;


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


    private String wareCode;


    private String areaCode;


    private String cellCode;


    private String toWareCode;


    private String toAreaCode;


    private String toCellCode;


    private String itemCode;

    /**
     * 订单数量
     */
    private Integer quantity;

    private String memo;

    private Integer state;
    private String addTime;
    private String taskTime;

    /**
     * 始终与bill_master的type保持一致
     */
    private Integer billType;

    /**
     * 实际数量
     */
    private Integer acceptQuantity;



    /**
     * 完成数量
     */
    private Integer completeQuantity;

    /**
     * 审核备注
     */
    private String checkMemo;

    private Integer companyId;

    private Integer batchId;


    //是否需要返库  1-需要 2-不需要   默认不需要
    private Integer needReturn;

    private  String  enterid;

    private String  cyItemCode;

    public String getCyItemCode() {
        return cyItemCode;
    }

    public void setCyItemCode(String cyItemCode) {
        this.cyItemCode = cyItemCode;
    }

    public String getAppearid() {
        return appearid;
    }

    public void setAppearid(String appearid) {
        this.appearid = appearid;
    }

    private String appearid;

    public String getEnterid() {
        return enterid;
    }

    public void setEnterid(String enterid) {
        this.enterid = enterid;
    }

    public Integer getNeedReturn() {
        return needReturn;
    }

    public void setNeedReturn(Integer needReturn) {
        this.needReturn = needReturn;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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
     * @return detail_no
     */
    public String getDetailNo() {
        return detailNo;
    }

    /**
     * @param detailNo
     */
    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    /**
     * @return bill_no
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * @return ware_code
     */
    public String getWareCode() {
        return wareCode;
    }

    /**
     * @param wareCode
     */
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    /**
     * @return area_code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return cell_code
     */
    public String getCellCode() {
        return cellCode;
    }

    /**
     * @param cellCode
     */
    public void setCellCode(String cellCode) {
        this.cellCode = cellCode;
    }

    /**
     * @return to_ware_code
     */
    public String getToWareCode() {
        return toWareCode;
    }

    /**
     * @param toWareCode
     */
    public void setToWareCode(String toWareCode) {
        this.toWareCode = toWareCode;
    }

    /**
     * @return to_area_code
     */
    public String getToAreaCode() {
        return toAreaCode;
    }

    /**
     * @param toAreaCode
     */
    public void setToAreaCode(String toAreaCode) {
        this.toAreaCode = toAreaCode;
    }

    /**
     * @return to_cell_code
     */
    public String getToCellCode() {
        return toCellCode;
    }

    /**
     * @param toCellCode
     */
    public void setToCellCode(String toCellCode) {
        this.toCellCode = toCellCode;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        if(taskTime ==""){
            this.taskTime = null;
        }else {
            this.taskTime = taskTime;
        }

    }

    /**
     * 获取始终与bill_master的type保持一致
     *
     * @return bill_type - 始终与bill_master的type保持一致
     */
    public Integer getBillType() {
        return billType;
    }

    /**
     * 设置始终与bill_master的type保持一致
     *
     * @param billType 始终与bill_master的type保持一致
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getAcceptQuantity() {
        return acceptQuantity;
    }

    public void setAcceptQuantity(Integer acceptQuantity) {
        this.acceptQuantity = acceptQuantity;
    }

    /**
     * 获取完成数量
     *
     * @return complete_quantity - 完成数量
     */
    public Integer getCompleteQuantity() {
        return completeQuantity;
    }

    /**
     * 设置完成数量
     *
     * @param completeQuantity 完成数量
     */
    public void setCompleteQuantity(Integer completeQuantity) {
        this.completeQuantity = completeQuantity;
    }

    /**
     * 获取审核备注
     *
     * @return check_memo - 审核备注
     */
    public String getCheckMemo() {
        return checkMemo;
    }

    /**
     * 设置审核备注
     *
     * @param checkMemo 审核备注
     */
    public void setCheckMemo(String checkMemo) {
        this.checkMemo = checkMemo;
    }

    /**
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}