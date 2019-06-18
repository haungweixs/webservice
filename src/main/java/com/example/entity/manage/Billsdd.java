package com.example.entity.manage;

/**
 * Created by LiWeijie
 * 19/04/12 11:23
 */
public class Billsdd {
    private  BillMaster  billMaster;
    private  BillDetail[] billDetails;

    public BillMaster getBillMaster() {
        return billMaster;
    }

    public void setBillMaster(BillMaster billMaster) {
        this.billMaster = billMaster;
    }

    public BillDetail[] getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetail[] billDetails) {
        this.billDetails = billDetails;
    }
}
