package com.example.entity.chuanyun;


/**
 * Created by LiWeijie
 * 19/06/21 17:58
 */
public class ChuanYunWareinfo {

    //仓库名称
    private  String wareName;
    //备注
    private  String  memo;
    //氚云id
    private  String  chaunyunid;
    //物料规格
    private String itemClass;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getChaunyunid() {
        return chaunyunid;
    }

    public void setChaunyunid(String chaunyunid) {
        this.chaunyunid = chaunyunid;
    }
}
