package com.example;

import com.example.service.wms.WmsService;
import com.example.service.wms.impl.WmsServiceimp;
import com.example.util.RestFul;

/**
 * Created by LiWeijie
 * 19/04/10 18:12CountDetail
 */
public class text {
    public static void main(String[] args) {
        WmsService wmsService =new WmsServiceimp();
        String  acctoken= RestFul.accToken();
        System.out.println(acctoken);
    }
}
