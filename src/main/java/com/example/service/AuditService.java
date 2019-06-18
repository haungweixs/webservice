package com.example.service;

import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.example.entity.Cost;
import com.taobao.api.ApiException;

import java.util.List;

/**
 * Created by LiWeijie
 * 19/03/18 10:43
 */
public interface AuditService {
    //添加流程实例
    public  String  createAudit(String accessToken,Cost jxiDhl) throws ApiException;
    //获取token
    public String accessToken() throws ApiException;
    //获取通讯录的部门id
    public String chlid(String accessToken) throws ApiException;
    //获取部门中的人员id
    public  String  userld(String accessToken,long chlid) throws ApiException;
}
