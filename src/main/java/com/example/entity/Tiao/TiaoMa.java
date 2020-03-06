package com.example.entity.Tiao;

import java.util.List;

/**
 * Created by LiWeijie
 * 19/10/21 17:11
 */
public class TiaoMa {
    private  String billNo;
    private List<ItemBta> itemBarcodeList;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public List<ItemBta> getItemBarcodeList() {
        return itemBarcodeList;
    }

    public void setItemBarcodeList(List<ItemBta> itemBarcodeList) {
        this.itemBarcodeList = itemBarcodeList;
    }
}
