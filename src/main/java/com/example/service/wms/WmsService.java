package com.example.service.wms;

import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by LiWeijie
 * 19/04/11 13:58
 */

public interface WmsService {

    //新增billMaster以及billDetail列表  入库单据
    public  String  insertWms(String  param) throws ParseException;

    //新增 出库单据
    public  String  intsercome(String  param) throws ParseException;

    //数据导入新增
    public  String   inshuju(String param) throws ParseException;

    public String  rukutiaoma(String param);

    //生成出库
    public  String  intrcome(String  param) throws ParseException;

    public String  chukuoma(String param) throws ParseException;

    public String  jiutiao(String param) throws ParseException;

    //新增客户
    public  String  client(String param);

    //修改客户
    public  String  clientUpdate(String param);

}
