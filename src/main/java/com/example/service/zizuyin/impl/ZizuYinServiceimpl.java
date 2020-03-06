package com.example.service.zizuyin.impl;

import com.example.entity.zizuyin.OutUser;
import com.example.entity.zizuyin.Register;
import com.example.service.zizuyin.ZizuYinService;
import com.example.util.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiWeijie
 * 19/08/15 14:16
 */
public class ZizuYinServiceimpl implements ZizuYinService {

    @Override
    public String Register(Register register) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",register.getName());
        map.put("mobile",register.getMobile());
        map.put("pwd",register.getPwd());
        map.put("url",register.getUrl());
        String json = null;
        try {
            json = HttpClientUtil.doPost("https://www.zhiguanyin.com.cn/mps1/out/register",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    /**
     * 增加租户信息
     */
    @Override
    public String outUserSave(OutUser outUser) {
        Map<String, Object> map = new HashMap<>();
        map.put("merchantName",outUser.getMerchantName());
        map.put("username",outUser.getUsername());
        map.put("pwd",outUser.getPwd());
        map.put("companyName",outUser.getCompanyName());
        map.put("mobile",outUser.getMobile());
        map.put("userId",outUser.getUserId());
        map.put("address",outUser.getAddress());
        String json = null;
        try {
            json = HttpClientUtil.doPost("https://www.zhiguanyin.com.cn/mps1/out/outUser/save",map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }
}
