package com.example.service.wms.impl;

import com.example.config.Constant;
import com.example.entity.basic.ItemMaster;
import com.example.entity.chuanyun.ChuanYunItemaster;
import com.example.service.wms.ItemeasServer;
import com.example.util.JacksonHelper;
import com.example.util.RestFul;

/**
 * Created by LiWeijie
 * 19/06/21 19:51
 */
public class ItemeasServerimpl implements ItemeasServer {
    @Override
    public String ItemasSave(String param) {
        ChuanYunItemaster chuanYunItemaster= JacksonHelper.fromJSON(param,ChuanYunItemaster.class);
        ItemMaster itemMaster=new ItemMaster();
        itemMaster.setItemMasterName(chuanYunItemaster.getItemMasterName());
        itemMaster.setChuanyunid(chuanYunItemaster.getChuanyunid());
        itemMaster.setMemo(chuanYunItemaster.getMemo());
        String  restFul= RestFul.RestFulPostToekn(Constant.ITEMASTER_INSERT,JacksonHelper.toJSON(itemMaster),RestFul.accToken());
        return restFul;
    }
}
