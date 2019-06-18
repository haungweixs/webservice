package com.example.service.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import java.lang.reflect.Array;
import com.example.entity.Cost;
import com.example.entity.Mixi;
import com.example.service.AuditService;
import com.taobao.api.ApiException;
import org.hibernate.validator.internal.metadata.aggregated.rule.ReturnValueMayOnlyBeMarkedOnceAsCascadedPerHierarchyLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by LiWeijie
 * 19/03/18 10:44
 */
public class AuditServiceImp implements AuditService {
    private static final Logger bizLogger = LoggerFactory.getLogger(AuditServiceImp.class);
    @Autowired
   public static AuditService auditService=new AuditServiceImp();
    @Override
    public String createAudit(String accessToken,Cost jxiDhl) throws ApiException {
      try {
          DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
          OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
          request.setAgentId(244493822L);
          request.setProcessCode("PROC-RIYJTXWV-K7Z3CU7Q2EQJFDRJP4GQ2-9NL8JJTJ-T");
          List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
          OapiProcessinstanceCreateRequest.FormComponentValueVo vo = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
          //用于循环赋值
          vo.setName("费用主题");
          vo.setValue(jxiDhl.getTheme());
          OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
          //用于循环赋值
          vo1.setName("objectid");
          vo1.setValue(jxiDhl.getObjectid());
          System.out.println(vo.getName());

          OapiProcessinstanceCreateRequest.FormComponentValueVo vo2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
          //用于循环赋值
          vo2.setName("剩余金额");
          vo2.setValue(jxiDhl.getBalance());

          OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
          //用于循环赋值
          vo3.setName("报销金额");
          vo3.setValue(jxiDhl.getMoney());

          OapiProcessinstanceCreateRequest.FormComponentValueVo obj7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
          //用于循环赋值
          obj7.setName("费用明细");
          List<Mixi>  list=jxiDhl.getDetails();
          List<OapiProcessinstanceCreateRequest.FormComponentValueVo> list2=new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
          List<Object> list3=new ArrayList<Object>();
          String  jsonString="";
          for (Mixi m:list){
              OapiProcessinstanceCreateRequest.FormComponentValueVo mix1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
              //用于循环赋值
              mix1.setName("类别");
              mix1.setValue(m.getLiebei());

              OapiProcessinstanceCreateRequest.FormComponentValueVo mix2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
              //用于循环赋值
              mix2.setName("金额");
              mix2.setValue(m.getZmoney());
              list2.add(mix1);
              list2.add(mix2);
              jsonString+=JSONObject.toJSONString(Arrays.asList(mix1,mix2))+",";
              list3.add(jsonString);
          }
          String  json="["+jsonString.substring(0,jsonString.length()-1)+"]";
          obj7.setValue(json);
          formComponentValues.add(vo);
          formComponentValues.add(vo1);
          formComponentValues.add(vo2);
          formComponentValues.add(vo3);
          formComponentValues.add(obj7);

          request.setFormComponentValues(formComponentValues);
          Long  deptsxs=Long.valueOf(jxiDhl.getDeptid());
          request.setDeptId(107124951L);
          System.out.println(request.getFormComponentValues());
          System.err.println();
          System.out.println();
          request.setOriginatorUserId(jxiDhl.getUserid());
          OapiProcessinstanceCreateResponse response = client.execute(request,accessToken);
          System.err.println(response.getErrmsg());
          return "发起审批实例成功";
      }catch (Exception e){
          return  "发起审批实例失败";
      }
    }

    @Override
    public String accessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("ding6rycbjltbjlhv9mi");
        request.setAppsecret("eBZBDU0gtNuS2II5CEDUCOn3UwuBH8FgMSSk0pmhe54XAM7JCl3hiBmmH3qugJBp");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        String token=response.getAccessToken();
        return token;
    }
    @Override
    public String userld(String accessToken, long chlid) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(chlid);
        request.setOffset(0L);
        request.setSize(10L);
        request.setHttpMethod("GET");
        OapiUserSimplelistResponse response = client.execute(request, accessToken);
        List<OapiUserSimplelistResponse.Userlist> userlist=response.getUserlist();
        for(OapiUserSimplelistResponse.Userlist user:userlist){
            System.out.println(user.getName()+"  "+user.getUserid()+""+chlid);
        }
        return  response.getBody();
    }
    @Override
    public String chlid(String accessToken) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_ids");
        OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
        request.setId("1");
        request.setHttpMethod("GET");
        OapiDepartmentListIdsResponse response = client.execute(request, accessToken);
        System.out.println(response.getErrmsg());
        List<Long> list=response.getSubDeptIdList();
        for (long l:list) {
            String  ui= String.valueOf(l);
            System.out.println(l);
        }
        return "dindkn";
    }

    public static void main(String[] args) throws ApiException {
        String  token=auditService.accessToken();

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_ids");
        OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
        request.setId("1");
        request.setHttpMethod("GET");
        OapiDepartmentListIdsResponse response = client.execute(request, token);
        System.out.println(response.getErrmsg());
        List<Long> list=response.getSubDeptIdList();
        for (long l:list) {
            String  ui= String.valueOf(l);
            auditService.userld(token,l);
        }
    }
}
