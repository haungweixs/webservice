package com.example.service.wms.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Constant;
import com.example.demo.JacksonHelper;
import com.example.entity.basic.Supplier4Json;
import com.example.entity.basic.SupplierManage;
import com.example.service.wms.SupplierManageService;
import com.example.util.RestFul;

public class SupplierManageServiceImpl implements SupplierManageService {

    @Override
    public String addSupplier(String param) {
        Supplier4Json supplier4Json = JacksonHelper.fromJSON(param,Supplier4Json.class);
        SupplierManage supplierManage = new SupplierManage();
        supplierManage.setMemo(supplier4Json.getMemo());
        supplierManage.setSupplierCode(supplier4Json.getSupplierCode());
        supplierManage.setSupplierContacts(supplier4Json.getSupplierContacts());
        supplierManage.setSupplierName(supplier4Json.getSupplierName());
        supplierManage.setSupplierPhone(supplier4Json.getSupplierPhone());
        String token = RestFul.accToken();
        String supplier = JSONObject.toJSONString(supplierManage);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_SUPPLIER_INSERT, supplier, token);
        System.out.println(message);
        return message;
    }
}
