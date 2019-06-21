package com.example.service.wms.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Constant;
import com.example.demo.JacksonHelper;
import com.example.entity.chuanyun.ChuanyunBillmaster;
import com.example.entity.chuanyun.ChuanyunBilldetail;
import com.example.entity.manage.BillDetail;
import com.example.entity.manage.BillMaster;
import com.example.entity.manage.Billsdd;
import com.example.service.wms.WmsService;
import com.example.util.RestFul;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LiWeijie
 * 19/04/11 13:59
 */
@Service
public class WmsServiceimp implements WmsService {
    @Override
    public String insertWms(String param) throws ParseException {
        ChuanyunBillmaster jxiDhl=JacksonHelper.fromJSON(param,ChuanyunBillmaster.class);
        int  number=(int)((Math.random()*9+1)*10000);    //生成5位随机数字s
        System.out.println(jxiDhl.getAddtime());
        String  d=jxiDhl.getAddtime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Date dbnud=sdf1.parse(d);
        System.out.println();
        String  time1=sdf.format(dbnud);
        String  BillNo="RK-"+2+"-"+sdf.format(dbnud)+"-"+number;
        System.out.println(BillNo);
        int  i=0;
        int  lenth=jxiDhl.getBilldetai().size();
        BillDetail[]  sdni=new BillDetail[lenth];
        for (ChuanyunBilldetail c:jxiDhl.getBilldetai()){
            BillDetail dui=new BillDetail();
            String detailNo = BillNo+"-"+i;
            dui.setDetailNo(detailNo);   //单据详情编号
            dui.setBillNo(detailNo);    //单据单号
            dui.setEnterid(c.getEnterid()); //入库子表id
            dui.setCyItemCode(c.getCyItemCode());      //物料编码 氚云格式
            dui.setQuantity(c.getQuantity());  //当前入库数量
            dui.setState(1);  //1-初始化；2-已经验收；3-已经上架
            dui.setAddTime(d); //添加时间
            dui.setBillType(1);        //1-入库   倍吗，把你们，、/+48/8*/8963/*9986532*986532*96532/2-出库 3-调拨
            dui.setCompanyId(2);
            dui.setBatch(c.getBatch());
            dui.setNeedReturn(2);
            sdni[i]=dui;
            i++;
        }
        BillMaster dxs=new BillMaster();
        dxs.setStatus(jxiDhl.getStatus());
        dxs.setBillNo(BillNo);
        dxs.setType(1);
        dxs.setAddUserId(4);
        dxs.setStatus(jxiDhl.getStatus());
        dxs.setAddTime(d);
        dxs.setState(1);
        dxs.setWareCode(jxiDhl.getWarecode());
        dxs.setCompanyId(2);
        dxs.setCyenterid(jxiDhl.getCyenterid());
        dxs.setMemo(jxiDhl.getRemark());
        dxs.setItemMasterId(jxiDhl.getItemMasterId());
        dxs.setContractNo(jxiDhl.getContractNo());
        String json1= JSONObject.toJSONString(dxs);
        Billsdd sdbn=new Billsdd();
        sdbn.setBillDetails(sdni);
        sdbn.setBillMaster(dxs);
        String js= JSONObject.toJSONString(sdbn);
        System.out.println(RestFul.accToken());
        String  shjdbded=RestFul.RestFulPostToekn(Constant.URL_POST_MASTER_INSERT,js,RestFul.accToken());
        System.out.println(shjdbded);
        return shjdbded;
    }

    @Override
    public String intsercome(String param) throws ParseException {
        ChuanyunBillmaster jxiDhl=JacksonHelper.fromJSON(param,ChuanyunBillmaster.class);
        int  number=(int)((Math.random()*9+1)*10000);    //生成5位随机数字
        System.out.println(jxiDhl.getAddtime());
        String  d=jxiDhl.getAddtime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Date dbnud=sdf1.parse(d);
        System.out.println();
        String  time1=sdf.format(dbnud);
        String  BillNo="CK-"+2+"-"+sdf.format(dbnud)+"-"+number;
        System.out.println(BillNo);
        int  i=0;
        int  lenth=jxiDhl.getBilldetai().size();
        BillDetail[]  sdni=new BillDetail[lenth];
        for (ChuanyunBilldetail c:jxiDhl.getBilldetai()){
            BillDetail dui=new BillDetail();
            String detailNo = BillNo+"-"+i;
            dui.setDetailNo(detailNo);   //单据详情编号
            dui.setBillNo(detailNo);    //单据单号
            dui.setAppearid(c.getAppearid());
            dui.setCyItemCode(c.getCyItemCode());      //物料编码  氚云格式
            dui.setQuantity(c.getQuantity());  //当前出库数量
            dui.setState(1);  //1-初始化；2-已经验收；3-已经上架
            dui.setAddTime(d); //添加时间
            dui.setBillType(2);        //1-入库 2-出库 3-调拨
            dui.setCompanyId(2);
            dui.setBatch(c.getBatch());
            dui.setNeedReturn(2);
            sdni[i]=dui;
            i++;
        }
        BillMaster dxs=new BillMaster();
        dxs.setCycomeid(jxiDhl.getCycomeid());
        dxs.setBillNo(BillNo);
        dxs.setChaunyunid(jxiDhl.getChaunyunid());
        dxs.setMold(jxiDhl.getMold());
        dxs.setType(2);
        dxs.setAddUserId(4);
        dxs.setAddTime(d);
        dxs.setState(1);
        dxs.setWareCode(jxiDhl.getWarecode());
        dxs.setCompanyId(2);
        dxs.setMemo(jxiDhl.getRemark());
        dxs.setItemMasterId(jxiDhl.getItemMasterId());
        dxs.setContractNo(jxiDhl.getContractNo());
        String json1= JSONObject.toJSONString(dxs);
        Billsdd sdbn=new Billsdd();
        sdbn.setBillDetails(sdni);
        sdbn.setBillMaster(dxs);
        String js= JSONObject.toJSONString(sdbn);
        String  shjdbded=RestFul.RestFulPostToekn(Constant.URL_POST_MASTER_INSERT,js,RestFul.accToken());
        System.out.println(shjdbded);
        return shjdbded;
    }

    public static void main(String[] args) {
        System.out.println(RestFul.accToken());
    }
}
