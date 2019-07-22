package com.example.demo1;

import com.example.service.ChuanYunService;
import com.example.service.impl.ChuanYunServiceImpl;

public class ItemCountQueryBackToCy {

    public static void backToCy(String count,String objectid){
        ChuanYunService chuanYunService = new ChuanYunServiceImpl();
        chuanYunService.UpdateBizObject("D001062inventory",objectid,"{count:'"+count+"'}");
    }

}
