package com.example.service.Messge;

import com.example.entity.chuanyun.ChuanYunhtsk;

import java.util.HashMap;

/**
 * Created by LiWeijie
 * 19/12/18 15:07
 */
public interface CCPRestSDKService {
    public String sendTemplateSMS(ChuanYunhtsk chuanYunhtsk) throws InterruptedException;

    public String  duanxinList(String json) throws InterruptedException;
}
