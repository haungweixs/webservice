package com.example.service.wms.impl;

import com.example.config.Constant;
import com.example.entity.basic.WareInfo;
import com.example.entity.chuanyun.ChuanYunWareinfo;
import com.example.service.wms.WareInfoServer;
import com.example.util.JacksonHelper;
import com.example.util.RestFul;
import org.springframework.stereotype.Service;

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
}
