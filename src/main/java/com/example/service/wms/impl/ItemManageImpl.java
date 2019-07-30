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
        brand.setBrandName(brand4Json.getBrandName());
        brand.setChuanyunId(brand4Json.getChuanyunId());
        String json = JSONObject.toJSONString(brand);
        System.out.println(json);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_BRAND_INSERT,json,RestFul.accToken());
        return message;
    }

    @Override
    public String updateBrand(String param) {
        Brand brand = new Brand();
        Brand4Json brand4Json = JacksonHelper.fromJSON(param,Brand4Json.class);
        brand.setBrandName(brand4Json.getBrandName());
        brand.setChuanyunId(brand4Json.getChuanyunId());
        String json = JSONObject.toJSONString(brand);
        String message = RestFul.RestFulPostToekn(Constant.URL_POST_BRAND_UPDATEBYCY,json,RestFul.accToken());
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
        itemType.setMainType(itemType4Json.getMainTypeId());
        itemType.setItemTypeName(itemType4Json.getTypeName());
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
        itemType.setMainType(itemType4Json.getMainTypeId());
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
       itemInfo.setMainType(itemInfo4Json.getItemMainType());
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
        itemInfo.setMainType(itemInfo4Json.getItemMainType());
        itemInfo.setItemName(itemInfo4Json.getItemName());
        itemInfo.setItemTypeCode("IT1120145777");
        itemInfo.setMemo(itemInfo4Json.getMemo());
        itemInfo.setSupplierCode("string");
        itemInfo.setUnitCode("string");
        itemInfo.setItemType(itemInfo4Json.getItemType());
        itemInfo.setDiscription(itemInfo4Json.getDiscription());
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
         String input1 = "?itemCode="+itemObjectid;
         String message1 = RestFul.RestFulGet(Constant.URL_GET_INVENTORY_SELECT,input1);
         Result1 result1 = JacksonHelper.fromJSON(message1,Result1.class);
         Integer count = result1.getData().getQuantity();//库内数量
         Integer outCount = result1.getData().getActualquantity();//已出数量
         Integer allCount = result1.getData().getToalquantity();//总数量
         Inventory inventory = new Inventory();
         inventory.setQuantity(count);
         inventory.setActualquantity(outCount);
         inventory.setToalquantity(allCount);
        ItemCountQueryBackToCy.backToCy(inventory,objectid);
        return count;
    }

    public static void main(String[] args) {
        ItemManageImpl itemManage = new ItemManageImpl();
        String param = "{\"itemObjectid\":\"b5a97853-2513-43b9-8927-8e18f5c327e7\",\"objectid\":\"f1b7a281-3d62-4503-a3c0-af3dd258e00e\"}\n";
        itemManage.queryItemCount(param);
    }
}
