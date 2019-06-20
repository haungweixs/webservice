package com.example.service;

/**
 * @Author: jiangbangfa
 * @Description:
 * @Date: Create in 14:17 2018/12/22
 */
public interface ChuanYunService {

    public  String  LoadBizObject(String SchemaCode, String BizObjectId);

    public  String  UpdateBizObject(String SchemaCode, String BizObjectId, String BizObject);

    public  String  LoadBizObjects(String SchemaCode, String Filter);

    public  String  CreateBizObject(String SchemaCode, String BizObject, String IsSubmit);

    public  String  CreateBizObjects(String SchemaCode, String BizObjectArray, String IsSubmit);

    public  String  RemoveBizObject(String SchemaCode, String BizObjectId);
}
