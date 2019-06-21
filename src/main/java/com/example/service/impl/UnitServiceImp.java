package com.example.service.impl;

import com.example.config.Constant;
import com.example.entity.basic.Unit;
import com.example.entity.chuanyun.ChuanYunUnit;
import com.example.service.UnitService;
import com.example.util.JacksonHelper;
import com.example.util.RandomNo;
import com.example.util.RestFul;

/**
 * Created by LiWeijie
 * 19/06/20 15:11
 */
public class UnitServiceImp implements UnitService {
    @Override
    public String UnitSave(String param) {
       ChuanYunUnit unitl=JacksonHelper.fromJSON(param,ChuanYunUnit.class);
        Unit unit=new Unit();
        unit.setUnitName(unitl.getUnitName());
        unit.setMemo(unitl.getMemo());
        unit.setChuanyunId(unitl.getChuanyunId());
        String restFul=RestFul.RestFulPostToekn(Constant.UNIT_POST_INSERT,JacksonHelper.toJSON(unit),RestFul.accToken());
        return restFul;
    }
}
