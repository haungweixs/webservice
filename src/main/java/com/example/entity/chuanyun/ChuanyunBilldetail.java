package com.example.entity.chuanyun;

/**
 * Created by LiWeijie
 * 19/04/15 12:35
 */
public class ChuanyunBilldetail {
     /**
     * 入库数量
     */
    private   Integer  quantity;
     /**
     * 批次
     */
    private   String  batch;
     /**
     * 备注
     */
    private   String  mold;
     /**
     * 入库=入库单据id  出库=合同id
     */
    private   String  chaunyunid;
     /**
     * 氚云入库子表id
     */
    private   String  enterid;
     /**
     * 氚云出库子表id
     */
    private  String  appearid;

    private String  cyItemCode;

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

    public String getCyItemCode() {
        return cyItemCode;
    }

    public void setCyItemCode(String cyItemCode) {
        this.cyItemCode = cyItemCode;
    }

    public String getEnterid() {
        return enterid;
    }

    public void setEnterid(String enterid) {
        this.enterid = enterid;
    }

    public String getAppearid() {
        return appearid;
    }

    public void setAppearid(String appearid) {
        this.appearid = appearid;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
