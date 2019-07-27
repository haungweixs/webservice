package com.example.service.wms.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Constant;
import com.example.demo.JacksonHelper;
import com.example.demo1.ItemCountQueryBackToCy;
import com.example.entity.basic.*;
import com.example.entity.chuanyun.ChuanyunBillmaster;
import com.example.service.impl.ChuanYunServiceImpl;
import com.example.service.wms.ItemManage;
import com.example.util.RandomNo;
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
        String message = RestFul.RestFulGetToken(Constant.URL_GET_ITEMINFO_DELETE, param, token);
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
        String message = RestFul.RestFulGetToken(Constant.URL_GET_ITEMTYPE_DELETE, param, token);

        System.out.println(token);
        return message;
    }

    /**
     * 添加单条物料分类信息
     * @param itemType
     * @return
     */
//    @Override
//    public String addItemType(ItemType itemType) {
//        ItemType4Json itemType4Json =
//        itemType.setItemTypeName("外星人1");
//        itemType.setItemTypeState(0);
//        itemType.setMemo("2019.04.16更新");
//        String token = RestFul.accToken();
//        String param = JSONObject.toJSONString(itemType);
//        System.out.println(param);
//        String message = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMTYPE_INSERT, param, token);
//        System.out.println(message);
//        return message;
//    }

    @Override
    public String updateItemType(ItemType itemType) {

        itemType.setItemTypeCode("IT123456789");
        itemType.setItemTypeName("外星人");
        itemType.setItemTypeState(0);
        itemType.setItemTypeId(49);
        itemType.setMemo("2019.04.17更新");
        String token = RestFul.accToken();
        String param = JSONObject.toJSONString(itemType);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMTYPE_UPDATE, param, token);
        return message;
    }

    @Override
    public String addBrand(String param) {
        Brand brand = new Brand();
        Brand4Json brand4Json = JacksonHelper.fromJSON(param,Brand4Json.class);
        brand.setBrandCode("1");
        brand.setBrandName(brand4Json.getBrandName());
        brand.setChuanyunid(brand4Json.getChuanyunid());
        brand.setCompanyId(0);
        brand.setId(0);
        String json = JSONObject.toJSONString(brand);
        String message = RestFul.RestFulPostToekn(json,Constant.URL_POST_BRAND_INSERT,RestFul.accToken());
        return message;
    }

    /**
     * 添加商品二级分类
     * @param param
     * @return
     */
    @Override
    public String addItemType(String param) {
        ItemType itemType = new ItemType();
        ItemType4Json itemType4Json = JacksonHelper.fromJSON(param,ItemType4Json.class);
        itemType.setMemo(itemType4Json.getMemo());
        itemType.setItemTypeId(0);
        if(itemType4Json.getState().equals("生效")){
            itemType.setItemTypeState(1);
        }else if(itemType4Json.getState().equals("失效")){
            itemType.setItemTypeState(0);
        }else if(itemType4Json.getState()==null){
            itemType.setItemTypeState(1);
        }
        itemType.setChuanyunid(itemType4Json.getChuanyunid());
        itemType.setMainType(itemType4Json.getMainType());
        String json = JSONObject.toJSONString(itemType);
        String result = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMTYPE_INSERT,json,RestFul.accToken());
        return result;
    }

    /**
     * 根据氚云id更新产品信息
     * @return
     */
    @Override
    public String updateItemType(String param) {
        ItemType itemType = new ItemType();
        ItemType4Json itemType4Json = JacksonHelper.fromJSON(param,ItemType4Json.class);
        itemType.setItemTypeName(itemType4Json.getTypeName());
        itemType.setMemo(itemType4Json.getMemo());
        itemType.setItemTypeId(0);
        if(itemType4Json.getState().equals("生效")){
            itemType.setItemTypeState(1);
        }else if(itemType4Json.getState().equals("失效")){
            itemType.setItemTypeState(0);
        }else if(itemType4Json.getState()==null){
            itemType.setItemTypeState(1);
        }
        itemType.setChuanyunid(itemType4Json.getChuanyunid());
        itemType.setMainType(itemType4Json.getMainType());
        String json = JSONObject.toJSONString(itemType);
        String result = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMTYPE_UPDATEBYCY,json,RestFul.accToken());
        return result;
    }


    @Override
    public String addItemInfo(String param) {
        ItemInfo itemInfo = new ItemInfo();
        ItemInfo4Json itemInfo4Json = JacksonHelper.fromJSON(param,ItemInfo4Json.class);
        itemInfo.setAbcClass("A");
        itemInfo.setBatch("abcd");
        //itemInfo.setCompanyId(112);//不需要设置公司，会自动把当前登录人的CompanyId传过去
        itemInfo.setDefaultPrice(10.0);
        itemInfo.setItemShortName(itemInfo4Json.getShortName());
        itemInfo.setItemBarCode(RandomNo.createNo3Size());
        String itemClass = itemInfo4Json.getItemClass();
        if(itemClass !="" && itemClass != null){
            itemInfo.setItemClass(itemInfo4Json.getItemClass());
        }else{
            itemInfo.setItemClass("无默认配置");
        }

        //itemInfo.setItemCode("IM10000021");//自动生成
        itemInfo.setItemName(itemInfo4Json.getItemName());
        itemInfo.setItemTypeCode("IT1120145777");
        itemInfo.setMemo(itemInfo4Json.getMemo());
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
       itemInfo.setItemType(itemInfo4Json.getItemType());
       itemInfo.setDiscription(itemInfo4Json.getDiscription());
       itemInfo.setMainType(itemInfo.getMainType());
       itemInfo.setBrand(itemInfo4Json.getBrand());
       itemInfo.setUnit(itemInfo4Json.getUnit());
        itemInfo.setWeight("100");
        itemInfo.setChuanyunid(itemInfo4Json.getChuanyunid());
        String token = RestFul.accToken();
        String item = JSONObject.toJSONString(itemInfo);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMINFO_INSERT, item, token);
        return message;
    }

//    @Override
//    public String queryItemInfoList(String itemInfo, Integer pageNum, Integer pageSize, String token) {
//        return null;
//    }

    @Override
    public String updateItemInfo(String  param) {
        System.out.println("通过氚云更新产品信息");
        ItemInfo itemInfo = new ItemInfo();
        ItemInfo4Json itemInfo4Json = JacksonHelper.fromJSON(param,ItemInfo4Json.class);
        itemInfo.setAbcClass("A");
        itemInfo.setBatch("abcd");
        //itemInfo.setCompanyId(112);//不需要设置公司，会自动把当前登录人的CompanyId传过去
        itemInfo.setDefaultPrice(10.0);
        itemInfo.setItemShortName(itemInfo4Json.getShortName());
        itemInfo.setItemBarCode(RandomNo.createNo3Size());
        itemInfo.setItemClass(itemInfo4Json.getItemClass());
        //itemInfo.setItemCode("IM10000021");//自动生成
        itemInfo.setItemName(itemInfo4Json.getItemName());
        itemInfo.setItemTypeCode("IT1120145777");
        itemInfo.setMemo(itemInfo4Json.getMemo());
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
        itemInfo.setItemType(itemInfo4Json.getItemType());
        itemInfo.setDiscription(itemInfo4Json.getDiscription());
        itemInfo.setMainType(itemInfo.getMainType());
        itemInfo.setBrand(itemInfo4Json.getBrand());
        itemInfo.setUnit(itemInfo4Json.getUnit());
        itemInfo.setWeight("100");
        itemInfo.setChuanyunid(itemInfo4Json.getChuanyunid());
        String token = RestFul.accToken();
        String item = JSONObject.toJSONString(itemInfo);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_ITEMINFO_UPDATEBYCY, item, token);
        return message;
    }

    @Override
    public String addMainType(String param) {
        ItemMainType itemMainType = new ItemMainType();
        ItemMainType4Json itemMainType4Json =  JacksonHelper.fromJSON(param,ItemMainType4Json.class);
        itemMainType.setId(0);
        itemMainType.setChuanyunid(itemMainType4Json.getChuanyunid());
        itemMainType.setTypeName(itemMainType4Json.getTypeName());
        String message = JSONObject.toJSONString(itemMainType);
        String result = RestFul.RestFulPost(Constant.URL_POST_ITEMMAINTYPE_INSERT,message);
        return result;
    }

    @Override
    public int queryItemCount(String param) {
         ItemInventory itemInventory  = JacksonHelper.fromJSON(param,ItemInventory.class);
         String itemObjectid = itemInventory.getItemObjectid();
         String objectid = itemInventory.getObjectid();
        //通过氚云产品objectid获取产品的code
         String input = "?chuanyunid="+itemObjectid;
         String message = RestFul.RestFulGet(Constant.URL_GET_ITEMINFOBYCYID_SELECT,input);

         Result result = JacksonHelper.fromJSON(message,Result.class);

        ItemInfo itemInfo = result.getData();

         //通过itemCode获取到产品的库存数量
        String itemCode = itemInfo.getItemCode();
        System.out.println(itemCode);
         String input1 = "?itemCode="+itemCode;
         String message1 = RestFul.RestFulGet(Constant.URL_GET_INVENTORY_SELECT,input1);
         Result1 result1 = JacksonHelper.fromJSON(message1,Result1.class);
         Integer count = result1.getData().getQuantity();
         String temp = count.toString();
        ItemCountQueryBackToCy.backToCy(temp,objectid);
        return count;
    }

    public static void main(String[] args) {
        ItemManageImpl itemManage = new ItemManageImpl();
        String param ="{\"chuanyunid\":\"ecbdacf6-6e9e-41e1-bf8f-dc4d4e742f6c\",\"typeName\":\"测试二级分类\",\"state\":\"生效\",\"mainTypeId\":\"e81b604c-75f0-4d51-a627-b13b1dea3077\",\"memo\":\"测试数据\"}\n";
        itemManage.addItemType(param);

    }
}
