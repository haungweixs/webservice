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
        System.out.println(jxiDhl.getOldOrNew());
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
        if(jxiDhl.getOldOrNew().equals("旧设备")){
            dxs.setNewOrOld(1);
        }else{
            dxs.setNewOrOld(0);
        }
        dxs.setChaunyunid(jxiDhl.getChaunyunid());
        dxs.setStatus(jxiDhl.getStatus());
        dxs.setBillNo(BillNo);
        dxs.setType(1);
        dxs.setAddUserId(4);
        dxs.setStatus(jxiDhl.getStatus());
        dxs.setAddTime(d);
        dxs.setState(1);
       dxs.setCyWareCode(jxiDhl.getCyWareCode());
       dxs.setCyItemmaster(jxiDhl.getCyItemmaster());
        dxs.setCompanyId(2);
        dxs.setCyenterid(jxiDhl.getCyenterid());
        dxs.setMemo(jxiDhl.getRemark());
        dxs.setContractNo(jxiDhl.getContractNo());
        System.out.println(dxs.getNewOrOld());
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
        String oldOrNew = jxiDhl.getOldOrNew();
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
        dxs.setCyItemmaster(jxiDhl.getCyItemmaster());
        dxs.setType(2);
        dxs.setAddUserId(4);
        dxs.setAddTime(d);
        dxs.setState(1);
        dxs.setCyWareCode(jxiDhl.getCyWareCode());
        dxs.setCyItemmaster(jxiDhl.getCyItemmaster());
        dxs.setCompanyId(2);
        dxs.setMemo(jxiDhl.getRemark());
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
//        String param = "{\"contractNo\":\"RK20190724003\",\"cyItemmaster\":\"\",\"cyWareCode\":\"089a89ca-aae8-4602-b52c-be4e0f4f331d\",\"remark\":\"测试旧设备\",\"cyenterid\":\"812110bc-62c7-4ffc-b0e8-f328448ddb73\",\"userid\":\"70641d44-c0e6-4971-ad73-00265a9df310\",\"addtime\":\"2019-07-24 14:16:19\",\"oldOrNew\":\"新设备\",\"status\":\"0\",\"billdetai\":[{\"cyItemCode\":\"76bab1c7-ecdc-4438-a072-262f638127be\",\"enterid\":\"12fce2c5-20af-411d-bce1-a20ae3959b6d\",\"quantity\":\"2\",\"batch\":\"2019-7-24\"}]}\n";
//        WmsService wmsService = new WmsServiceimp();
//        try{
//            wmsService.insertWms(param);
//
//        }catch (Exception e){
//
//        }


    }
}
