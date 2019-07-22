package com.example.config;

/**
 * Created by LiWeijie
 * 19/04/12 10:26
 */
public class Constant {
    //访问系统以及相关api接口的TOKEN地址
    public  static  final String URL_POST_TOKEN="http://47.98.150.253:8000/wms/login";

    //新增billMaster以及billDetail列表    //新增出入库单据
    public   static  final String  URL_POST_MASTER_INSERT="http://47.98.150.253:8000/wms/bill/masters/insert";

    public static final String URL_POST_ITEMINFO_INSERT="http://47.98.150.253:8000/wms/item/infos/insert";

    public static  final String URL_POST_ITEMMAINTYPE_INSERT="http://47.98.150.253:8000/wms/item/maintypes/insert";

    public static final String URL_POST_ITEMTYPE_INSERT="http://47.98.150.253:8000/wms/item/types/insert";

    //新增单位表
    public  static  final  String  UNIT_POST_INSERT="http://47.98.150.253:8000/wms/units/insert";

    //新增仓库表
    public   static  final  String  WAREINFO_INSERT="http://47.98.150.253:8000/wms/ware/infos/insert";

    //新增货主表
    public   static  final   String ITEMASTER_INSERT="http://47.98.150.253:8000/wms/item/masters/insert";


    //新增品牌
    public static final String URL_POST_BRAND_INSERT="http://47.98.150.253:8000/wms/brands/insert";

    //通过产品氚云id获取产品
    public static final String URL_GET_ITEMINFOBYCYID_SELECT="http://47.98.150.253:8000/wms/item/infos/detailByC";

    //通过itemCode获取库存数量
    public static final String URL_GET_INVENTORY_SELECT="http://47.98.150.253:8000/wms/inventorys/itemCode";

    //新增商品信息
    //public static final String URL_POST_ITEMINFO_UPDATE="http://47.98.150.253:8000/wms/item/infos/update";

    //根据氚云id更新产品信息
    public static final String URL_POST_ITEMINFO_UPDATEBYCY = "http://47.98.150.253:8000/wms/item/infos/updateByChuanyunid";

    //更新产品类型
    public static final String  URL_POST_ITEMTYPE_UPDATE ="http://47.98.150.253:8000/wms/item/types/update";

    //删除产品信息
    public static final String URL_GET_ITEMINFO_DELETE="http://47.98.150.253:8000/wms/item/infos/delete";

    //删除单条产品分类信息
    public static final String URL_GET_ITEMTYPE_DELETE="http://47.98.150.253:8000/wms/item/types/delete";



}
