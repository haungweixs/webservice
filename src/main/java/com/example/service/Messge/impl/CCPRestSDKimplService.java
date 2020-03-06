package com.example.service.Messge.impl;

import com.example.config.Constant;
import com.example.entity.chuanyun.ChuanYunhtsk;
import com.example.entity.chuanyun.ChuanYunhtsks;
import com.example.service.Messge.CCPRestSDKService;
import com.example.service.Messge.YunTo;
import com.example.util.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by LiWeijie
 * 19/12/18 15:08
 */
public class CCPRestSDKimplService implements CCPRestSDKService {

    @Override
    public String sendTemplateSMS(ChuanYunhtsk chuanYunhtsk) throws InterruptedException {
        String  dateTime=DateUtils.getNowDateTimeString();
        Thread.sleep(15 * 1000); //设置暂停的时间 5 秒
        String SigParameter=MD5.encode(Constant.accountSid+Constant.accountToken+dateTime);
        String YUNUrl="https://app.cloopen.com:8883/2013-12-26/Accounts/8a48b5515350d1e201537968ad5642ea/SMS/TemplateSMS?sig="+SigParameter;
        YunTo yunTo=new YunTo();
        yunTo.setTo(chuanYunhtsk.getPhone());
        yunTo.setAppId("8a48b5515350d1e2015379d2f44643ff");
        yunTo.setTemplateId("492114");
        yunTo.setDatas("['"+chuanYunhtsk.getSeqno()+"','"+chuanYunhtsk.getClientname()+"','"+chuanYunhtsk.getMoney()+"']");
        yunTo.setSubAppend("8888");
        yunTo.setReqId(RandomNo.createNo());
        String json= JacksonHelper.toJSON(yunTo);
        String retu= HttpClient.postData(json,YUNUrl,"utf-8",dateTime);
        return retu;
    }

    @Override
    public String duanxinList(String json) throws InterruptedException {
        ChuanYunhtsks chuanYunhtsks=JacksonHelper.fromJSON(json,ChuanYunhtsks.class);
        for (ChuanYunhtsk sh:chuanYunhtsks.getChuanYunhtsks()){
            String  dateTime=DateUtils.getNowDateTimeString();
            Thread.sleep(30 * 1000); //设置暂停的时间 5 秒
            String SigParameter=MD5.encode(Constant.accountSid+Constant.accountToken+dateTime);
            String YUNUrl="https://app.cloopen.com:8883/2013-12-26/Accounts/8a48b5515350d1e201537968ad5642ea/SMS/TemplateSMS?sig="+SigParameter;
            YunTo yunTo=new YunTo();
            yunTo.setTo(sh.getPhone());
            yunTo.setAppId("8a48b5515350d1e2015379d2f44643ff");
            yunTo.setTemplateId("492114");
            yunTo.setDatas("['"+sh.getSeqno()+"','"+sh.getClientname()+"','"+sh.getMoney()+"']");
            yunTo.setSubAppend("8888");
            yunTo.setReqId(RandomNo.createNo());
            String Ytxjson= JacksonHelper.toJSON(yunTo);
            String retu= HttpClient.postData(Ytxjson,YUNUrl,"utf-8",dateTime);
        }
        return "操作成功";
    }
}
