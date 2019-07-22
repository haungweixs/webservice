package com.example.service.wms.impl;

import com.example.config.Constant;
import com.example.entity.basic.WareInfo;
import com.example.entity.chuanyun.ChuanYunWareinfo;
import com.example.service.wms.WareInfoServer;
import com.example.util.JacksonHelper;
import com.example.util.RestFul;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by LiWeijie
 * 19/06/21 18:04
 */
@Service
public class WareInfoServerImpl implements WareInfoServer {
    @Override
    public String saveWareInfo(String param) {
        ChuanYunWareinfo wareInfo1= JacksonHelper.fromJSON(param,ChuanYunWareinfo.class);
        WareInfo  wareInfo=new WareInfo();
        wareInfo.setMemo(wareInfo1.getMemo());
        wareInfo.setChaunyunid(wareInfo1.getChaunyunid());
        wareInfo.setWareName(wareInfo1.getWareName());
        String  restFul= RestFul.RestFulPostToekn(Constant.WAREINFO_INSERT,JacksonHelper.toJSON(wareInfo),RestFul.accToken());
        return restFul;
    }

    public static void main(String[] args) {
        Bargain bargain=new Bargain();
        bargain.setId("161d58764f9845349bc25f8abb1c5b26");
        bargain.setYsmoney(BigDecimal.valueOf(100.000000));
//        String  restFul= RestFul.RestFulPost("http://localhost:9074/text/proceeds",JacksonHelper.toJSON(bargain));
        String  restFul= RestFul.RestFulPost("http://localhost:9074/text/save","0c6c1cd40e674b1fa3b02ff06edbd5fa");



//        Bargain bargain1=new Bargain();
//        bargain.setAddtime("2018-07-04 16:35:23.0");
//        bargain.setEndtime("2019-07-04 16:35:31.0");
//        bargain.setParties("[{\"id\":\"2c93b9156b8c5707016b8ddea5530973\",\"imgUrl\":\"https://static.dingtalk.com/media/lADPBE1XX0KNcwnNAwPNAv8_767_771.jpg\",\"name\":\"黄炜\",\"type\":3}]");
//        bargain.setSummoney(BigDecimal.valueOf(1000.000000));
//        bargain.setSection("[{\"id\":\"2c93b9156b8c5707016b8ddea5530973\",\"imgUrl\":\"https://static.dingtalk.com/media/lADPBE1XX0KNcwnNAwPNAv8_767_771.jpg\",\"name\":\"黄炜\",\"type\":3}]");
//        bargain.setSkfs("按季度");
//        bargain.setTheme("ceshi");
//        String  restFul1= RestFul.RestFulPost("http://localhost:9074/text/save",JacksonHelper.toJSON(bargain));
//        System.out.println(restFul1);
    }

}
