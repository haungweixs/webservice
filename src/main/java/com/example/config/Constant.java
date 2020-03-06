package com.example.config;

/**
 * Created by LiWeijie
 * 19/04/12 10:26
 */
public class Constant {
    //访问系统以及相关api接口的TOKEN地址
    public  static  final String  domainname ="127.0.0.1";
    public  static  final String URL_POST_TOKEN="http://"+domainname+":8000/wms/login";
    public   static  final String  URL_POST_MASTER_INSERT="http://"+domainname+":8000/wms/bill/masters/insert";

   public   static  final String  URL_POST_MASTER_TIAOMA="http://"+domainname+":8000/wms/bill/logrecord/rukutiam";   //条码

   public   static  final String  URL_POST_MASTER_JTIAOMA="http://"+domainname+":8000/wms/bill/logrecord/recycleCode";   //旧条码


   public   static  final String  URL_POST_MASTER_CHUTIAOMA="http://"+domainname+":8000/wms/bill/logrecord/chukutiam";

   public static final String URL_POST_ITEMINFO_INSERT="http://"+domainname+":8000/wms/item/infos/insert";

    public static  final String URL_POST_ITEMMAINTYPE_INSERT="http://"+domainname+":8000/wms/item/maintypes/insert";

    public static final String URL_POST_ITEMTYPE_INSERT="http://"+domainname+":8000/wms/item/types/insert";

    //新增单位表
    public  static  final  String  UNIT_POST_INSERT="http://"+domainname+":8000/wms/units/insert";

    //新增仓库表
    public   static  final  String  WAREINFO_INSERT="http://"+domainname+":8000/wms/ware/infos/insert";

    //新增货主表
    public   static  final   String ITEMASTER_INSERT="http://"+domainname+":8000/wms/item/masters/insert";


    //新增品牌
    public static final String URL_POST_BRAND_INSERT="http://"+domainname+":8000/wms/brands/insert";

    //通过氚云更新品牌信息
    public static final String URL_POST_BRAND_UPDATEBYCY="http://"+domainname+":8000/wms/brands/updateByCy";

    //通过产品氚云id获取产品
    public static final String URL_GET_ITEMINFOBYCYID_SELECT="http://"+domainname+":8000/wms/item/infos/detailByC";

    //通过itemCode获取库存数量
    public static final String URL_GET_INVENTORY_SELECT="http://"+domainname+":8000/wms/inventorys/itemCode";

    //修改商品信息
    //public static final String URL_POST_ITEMINFO_UPDATE="http://"+domainname+":8000/wms/item/infos/update";

    //根据氚云id更新产品信息
    public static final String URL_POST_ITEMINFO_UPDATEBYCY = "http://"+domainname+":8000/wms/item/infos/updateByChuanyunid";

    //更新产品类型
    public static final String  URL_POST_ITEMTYPE_UPDATE ="http://"+domainname+":8000/wms/item/types/update";

    //删除产品信息
    public static final String URL_GET_ITEMINFO_DELETE="http://"+domainname+":8000/wms/item/infos/delete";

    //删除单条产品分类信息
    public static final String URL_GET_ITEMTYPE_DELETE="http://"+domainname+":8000/wms/item/types/delete";

    //更新产品二级分类
    public static final String URL_POST_ITEMTYPE_UPDATEBYCY = "http://"+domainname+":8000/wms/item/types/updateByCy";

    //添加供应商
    public static final String URL_POST_SUPPLIER_INSERT="http://"+domainname+":8000/wms/supplier/manages/insert";

    public  static  final  String  CLIENT_POST_CREATE="http://"+domainname+":8000/wms/client/manages/insert";

    public  static  final  String  CLIENT_POST_UPDATE="http://"+domainname+":8000/wms/client/manages/update";

    public  static final String accountSid="8a48b5515350d1e201537968ad5642ea";

    public  static final String accountToken="608f09f2c01146548a22b421437e7fd5";

}
