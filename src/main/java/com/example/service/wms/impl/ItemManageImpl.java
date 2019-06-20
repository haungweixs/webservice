package com.example.service.wms.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Constant;
import com.example.demo.JacksonHelper;
import com.example.entity.basic.ItemInfo;
import com.example.entity.basic.ItemInfo4Json;
import com.example.entity.basic.ItemType;
import com.example.entity.chuanyun.ChuanyunBillmaster;
import com.example.service.wms.ItemManage;
import com.example.util.RestFul;

public class ItemManageImpl implements ItemManage {

    /**
     * 删除单条物料信息
     * @param itemCode
     * @return
     */
    @Override
    public String deleteItemInfo(String itemCode) {
        String param = "?itemCode=" + itemCode;
        String token = RestFul.accToken();
        String message = RestFul.RestFulGetToken("http://127.0.0.1:8000/wms/item/infos/delete", param, token);
        return message;
    }

    // @Override
    //public String queryItemInfoByItemBarCode(String itemBarCode) {
//
//        return null;
//    }

    /**
     * 删除单条物料分类信息
     * @param itemTypeCode
     * @return
     */
    @Override
    public String deleteItemType(String itemTypeCode) {
        String param = "?itemTypeCode=" + itemTypeCode;
        String token = RestFul.accToken();
        String message = RestFul.RestFulGetToken("http://127.0.0.1:8000/wms/item/types/delete", param, token);

        System.out.println(token);
        return message;
    }

    /**
     * 添加单条物料分类信息
     * @param itemType
     * @return
     */
    @Override
    public String addItemType(ItemType itemType) {
        //itemType.setCompanyId(112); //不需要设置公司，会自动把当前登录人的CompanyId传过去
        //itemType.setItemTypeCode("IT123456789");//自动生成
        itemType.setItemTypeName("外星人1");
        itemType.setItemTypeState(0);
        itemType.setMemo("2019.04.16更新");
        String token = RestFul.accToken();
        String param = JSONObject.toJSONString(itemType);
        System.out.println(param);
        String message = RestFul.RestFulToekn("http://127.0.0.1:8000/wms/item/types/insert", param, token);
        System.out.println(message);
        return message;
    }

    @Override
    public String updateItemType(ItemType itemType) {

        itemType.setItemTypeCode("IT123456789");
        itemType.setItemTypeName("外星人");
        itemType.setItemTypeState(0);
        itemType.setItemTypeId(49);
        itemType.setMemo("2019.04.17更新");
        String token = RestFul.accToken();
        String param = JSONObject.toJSONString(itemType);
        String message = RestFul.RestFulToekn("http://127.0.0.1:8000/wms/item/types/update", param, token);
        return message;
    }

    @Override
    public String addItemInfo(String param) {
        ItemInfo itemInfo = new ItemInfo();
        ItemInfo4Json itemInfo4Json = JacksonHelper.fromJSON(param,ItemInfo4Json.class);
        itemInfo.setAbcClass("A");
        itemInfo.setBatch("abcd");
        //itemInfo.setCompanyId(112);//不需要设置公司，会自动把当前登录人的CompanyId传过去
        itemInfo.setDefaultPrice(10.0);
        itemInfo.setFloorLimit(10);
        itemInfo.setItemBarCode("123123123");
        itemInfo.setItemClass("有打");
        //itemInfo.setItemCode("IM10000021");//自动生成
        itemInfo.setItemName(itemInfo4Json.getItemName());
        itemInfo.setItemTypeCode("IT1120145777");
        itemInfo.setMemo(itemInfo4Json.getMemo());
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
        itemInfo.setUpperLimit(50);
        itemInfo.setWeight("100");
        itemInfo.setChuanyunid(itemInfo4Json.getChuanyunid());
        String token = RestFul.accToken();
        String item = JSONObject.toJSONString(itemInfo);
        String message = RestFul.RestFulToekn(Constant.URL_POST_ITEMINFO_INSERT, item, token);
        return message;
    }

//    @Override
//    public String queryItemInfoList(String itemInfo, Integer pageNum, Integer pageSize, String token) {
//        return null;
//    }

    @Override
    public String updateItemInfo(ItemInfo itemInfo) {
        itemInfo.setId(390);//----sql中查询的字段，不可为空，否则不能进行更新
        itemInfo.setAbcClass("B");
        itemInfo.setBatch("abcd");
        itemInfo.setCompanyId(112);
        itemInfo.setDefaultPrice(10.0);
        itemInfo.setFloorLimit(10);
        itemInfo.setItemBarCode("123123123");
        itemInfo.setItemClass("有打");
        itemInfo.setItemCode("IM25185338");
        itemInfo.setItemName("打印机001");
        itemInfo.setItemTypeCode("IT1120145777");
        itemInfo.setMemo("测试003");
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
        itemInfo.setUpperLimit(50);
        itemInfo.setWeight("100");
        String token = RestFul.accToken();
        String param = JSONObject.toJSONString(itemInfo);
        System.out.println(param + "--" + token);
        String message = RestFul.RestFulToekn("http://127.0.0.1:8000/wms/item/infos/update", param, token);
        System.out.println(message);
        return message;
    }

    public static void main(String[] args) {
        ItemManageImpl itemManage = new ItemManageImpl();
        //itemManage.deleteItemInfo("IM22150834");

        // itemManage.addItemInfo(new ItemInfo());
        //itemManage.updateItemInfo(new ItemInfo());
        //itemManage.updateItemType(new ItemType());
        //itemManage.deleteItemType("IT123456789");
    }
}
