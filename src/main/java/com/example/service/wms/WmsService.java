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
}
