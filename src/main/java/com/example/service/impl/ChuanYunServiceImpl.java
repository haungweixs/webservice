package com.example.service.impl;


import com.example.service.ChuanYunService;
import com.example.util.HttpRequestUtil;
import com.example.util.JacksonHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jiangbangfa
 * @Description:
 * @Date: Create in 14:18 2018/12/22
 */
//@Service价格这个，然后在Controller里面@Autowired注入就行了
public class ChuanYunServiceImpl implements ChuanYunService {

    private  final static String url="https://www.h3yun.com/OpenApi/Invoke";

    @Override
    public String LoadBizObject(String SchemaCode, String BizObjectId) {
        //请求结构体
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "LoadBizObject");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("BizObjectId",BizObjectId);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }

    @Override
    public String UpdateBizObject(String SchemaCode, String BizObjectId, String BizObject) {
        //请求结构体
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "UpdateBizObject");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("BizObjectId",BizObjectId);
        paramMap.put("BizObject",BizObject);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }

    @Override
    public String LoadBizObjects(String SchemaCode, String Filter) {
        //请求结构体
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "LoadBizObjects");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("Filter",Filter);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }

    @Override
    public String CreateBizObject(String SchemaCode, String BizObject, String IsSubmit) {
        //请求结构体
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "CreateBizObject");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("BizObject",BizObject);
        paramMap.put("IsSubmit",IsSubmit);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }

    @Override
    public String CreateBizObjects(String SchemaCode, String BizObjectArray, String IsSubmit) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "CreateBizObjects");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("BizObjectArray",BizObjectArray);
        paramMap.put("IsSubmit",IsSubmit);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }

    @Override
    public String RemoveBizObject(String SchemaCode, String BizObjectId) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("ActionName", "CreateBizObjects");
        paramMap.put("SchemaCode",SchemaCode);
        paramMap.put("BizObjectId",BizObjectId);

        JacksonHelper gson = new JacksonHelper();
        String json=gson.toJSON(paramMap);
        System.out.println(json);
        String result = HttpRequestUtil.sendPost("https://www.h3yun.com/OpenApi/Invoke",gson.toJSON(paramMap));
        return result;
    }


}
