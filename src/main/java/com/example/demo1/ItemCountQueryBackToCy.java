package com.example.demo1;

import com.example.entity.basic.Inventory;
import com.example.service.ChuanYunService;
import com.example.service.impl.ChuanYunServiceImpl;

public class ItemCountQueryBackToCy {

    public static void backToCy(Inventory inventory, String objectid){
        ChuanYunService chuanYunService = new ChuanYunServiceImpl();
        String count = inventory.getQuantity().toString();
        String outCount = inventory.getActualquantity().toString();
        String allCount = inventory.getToalquantity().toString();
        chuanYunService.UpdateBizObject("D001062inventory",objectid,"{count:'"+count+"',outCount:'"+outCount+"',allCount:'"+allCount+"'}");
    }

}
