package com.example.entity.manage;



public class BillMaster {
    private Integer id;

    /**
     * 编码
     */

    private Integer neworold;

    /**
     * 供应商code
     */
    private String supplierCode;

    /**
     * 客户code
     * */
    private String   clientCode;

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Integer getNeworold() {
        return neworold;
    }

    public void setNeworold(Integer neworold) {
        this.neworold = neworold;
    }

    private String billNo;

    private Integer  status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 1-入库 2-出库 3-移库 4-调拨
     */
    private Integer type;

    private String dealTime;
    private String recycleTime;
    private String recycleType;

    public String getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(String recycleType) {
        this.recycleType = recycleType;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getRecycleTime() {
        return recycleTime;
    }

    public void setRecycleTime(String recycleTime) {
        this.recycleTime = recycleTime;
    }





    private Integer addUserId;

    private Integer checkUserId;

    private Integer taskUserId;

    private Integer acceptUserId;
    //合同id
    private String   chaunyunid;

    private String  mold;

    public String getChaunyunid() {
        return chaunyunid;
    }

    public void setChaunyunid(String chaunyunid) {
        this.chaunyunid = chaunyunid;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    private String addTime;
    private String checkTime;
    private String taskTime;
    private String acceptTime;

    private  String  cyWareCode;

    private  String  cyItemmaster;

    public String getCyWareCode() {
        return cyWareCode;
    }

    public void setCyWareCode(String cyWareCode) {
        this.cyWareCode = cyWareCode;
    }

    public String getCyItemmaster() {
        return cyItemmaster;
    }

    public void setCyItemmaster(String cyItemmaster) {
        this.cyItemmaster = cyItemmaster;
    }

    /**
     * 1-初始化 2-审核 3-作业中 4-完成
     */
    private Integer state;

    /**
     * 仓库编码
     */

    private String wareCode;

    //入库id
    private String cyenterid;
    //出库id
    private String cycomeid;

    public String getCyenterid() {
        return cyenterid;
    }

    public void setCyenterid(String cyenterid) {
        this.cyenterid = cyenterid;
    }

    public String getCycomeid() {
        return cycomeid;
    }

    public void setCycomeid(String cycomeid) {
        this.cycomeid = cycomeid;
    }

    /**
     * 所属公司（云仓库使用）
     */
    private Integer companyId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 批次
     */
    private Integer batch;

    /**
     * 合同号
     * */
    private String contractNo;




    //入库类型  1-采购入库  2-返库
    private Integer inType;

    public Integer getInType() {
        return inType;
    }

    public void setInType(Integer inType) {
        this.inType = inType;
    }

    public Integer getAddUserId() {
        return addUserId;
    }
    //创建人
    public void setAddUserId(Integer addUserId) {
        this.addUserId = addUserId;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Integer getTaskUserId() {
        return taskUserId;
    }

    public void setTaskUserId(Integer taskUserId) {
        this.taskUserId = taskUserId;
    }

    public Integer getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(Integer acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    private Integer itemMasterId;



    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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
     * 获取编码
     *
     * @return bill_no - 编码
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * 设置编码
     *
     * @param billNo 编码
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * 获取1-入库 2-出库 3-移库 4-调拨
     *
     * @return type - 1-入库 2-出库 3-移库 4-调拨
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1-入库 2-出库 3-移库 4-调拨
     *
     * @param type 1-入库 2-出库 3-移库 4-调拨
     */
    public void setType(Integer type) {
        this.type = type;
    }





    /**
     * 获取1-初始化 2-审核 3-作业中 4-完成
     *
     * @return state - 1-初始化 2-审核 3-作业中 4-完成
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1-初始化 2-审核 3-作业中 4-完成
     *
     * @param state 1-初始化 2-审核 3-作业中 4-完成
     */
    public void setState(Integer state) {
        this.state = state;
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
     * 获取所属公司（云仓库使用）
     *
     * @return company_id - 所属公司（云仓库使用）
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置所属公司（云仓库使用）
     *
     * @param companyId 所属公司（云仓库使用）
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
     * 获取批次
     *
     * @return batch - 批次
     */
    public Integer getBatch() {
        return batch;
    }

    /**
     * 设置批次
     *
     * @param batch 批次
     */
    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }



    public Integer getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }
}