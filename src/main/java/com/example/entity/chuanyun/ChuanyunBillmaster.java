package com.example.entity.chuanyun;

import java.util.List;

/**
 * Created by LiWeijie
 * 19/04/15 12:30
 */
public class ChuanyunBillmaster {
    private   String  contractNo;
    private   Integer  itemMasterId;
    private   String  warecode;
    private   Integer  status;
    private String supplierCode;
    private String dealTime;
    private String recycleTime;

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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private   String  remark;
    private   String  userid;
    private   String addtime;
    private    String mold;
    private   String  chaunyunid;
    private  String  cyWareCode;

    private  String  cyItemmaster;
    private String oldOrNew;
    private String supplier;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOldOrNew() {
        return oldOrNew;
    }

    public void setOldOrNew(String oldOrNew) {
        this.oldOrNew = oldOrNew;
    }

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

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public String getChaunyunid() {
        return chaunyunid;
    }

    public void setChaunyunid(String chaunyunid) {
        this.chaunyunid = chaunyunid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    private   String  billdetail;
    private    List<ChuanyunBilldetail>  billdetai;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBilldetail() {
        return billdetail;
    }

    public void setBilldetail(String billdetail) {
        this.billdetail = billdetail;
    }

    public List<ChuanyunBilldetail> getBilldetai() {
        return billdetai;
    }

    public void setBilldetai(List<ChuanyunBilldetail> billdetai) {
        this.billdetai = billdetai;
    }
}
