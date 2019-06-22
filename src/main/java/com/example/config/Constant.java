package com.example.config;

/**
 * Created by LiWeijie
 * 19/04/12 10:26
 */
public class Constant {
    //访问系统以及相关api接口的TOKEN地址
    public  static  final String URL_POST_TOKEN="http://127.0.0.1:8000/wms/login";

    //新增billMaster以及billDetail列表    //新增出入库单据
    public   static  final String  URL_POST_MASTER_INSERT="http://127.0.0.1:8000/wms/bill/masters/insert";

    public static final String URL_POST_ITEMINFO_INSERT="http://127.0.0.1:8000/wms/item/infos/insert";

    public static  final String URL_POST_ITEMMAINTYPE_INSERT="http://127.0.0.1:8000/wms/item/maintypes/insert";

    public static final String URL_POST_ITEMTYPE_INSERT="http://127.0.0.1:8000/wms/item/types/insert";

    //新增单位表
    public  static  final  String  UNIT_POST_INSERT="http://127.0.0.1:8000/wms/units/insert";

    public static final String URL_POST_BRAND_INSERT="http://127.0.0.1:8000/wms/brands/insert";
}
