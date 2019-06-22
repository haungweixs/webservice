package com.example.demo1;

import com.example.demo.JacksonHelper;
import com.example.demo.Query;
import com.example.entity.*;
import com.example.pojo.PinYinUtil;
import com.example.service.AuditService;
import com.example.service.UnitService;
import com.example.service.impl.AuditServiceImp;
import com.example.service.impl.UnitServiceImp;
import com.example.service.wms.ItemManage;
import com.example.service.wms.WmsService;
import com.example.service.wms.impl.ItemManageImpl;
import com.example.service.wms.impl.WmsServiceimp;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://demo1.example.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.example.demo1.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Autowired
    public static AuditService auditService = new AuditServiceImp();


    public static WmsService wmsService = new WmsServiceimp();

    @Autowired
    public static ItemManage itemManage = new ItemManageImpl();

    //
    public static UnitService unitService = new UnitServiceImp();

    @Override
    public String GetSchema(String schemaCode) {
        System.out.println(schemaCode);
        return " {\"Code\":\"D001062ceshi2\",\"Items\":[{\"Name\":\"F0000001\",\"DisplayName\":\"单行文本\",\"DataType\":\"String\"},]}";
    }

    @Override
    public String GetSchemaList() {
        return "{\"customer\": \"测试\",\"D001062ceshi2\": \"测试\"}";
    }

    @Override
    public String GetList(String userCode, String schemaCode, String filter) {
        return "{\"Code\":\"0\",\"Message\":\"获取数据成功\",\"Schema\":{\"Code\":\"D001062ceshi2\",\"Items\":[{\"name\":\"F0000001\",\"DisplayName\":\"单行文本\",\"DataType\":\"String\"}],},\"Data\":[\"F0000001\":\"c而是\"]}";

    }

    @Override
    public String Invoke(String userCode, String schemaCode, String methodName, String param) {
        System.out.println(param);
        try {
            String json = "";
            if (schemaCode.equals("D001062htkp") && methodName.equals("Getexpress")) {
                Query dui = new Query();
                JxiDhl jxiDhl = JacksonHelper.fromJSON(param, JxiDhl.class);
                String com = PinYinUtil.ToPinyin(jxiDhl.getCom().toString());
                String num = jxiDhl.getNum();
                String objectid = jxiDhl.getObjectid();
                System.out.println(com);
                kuaidix kd = dui.fanhuineiro(num, com, objectid);
            } else if (schemaCode.equals("D001062cost") && methodName.equals("Auditr")) {
                Cost jxiDhl = JacksonHelper.fromJSON(param, Cost.class);
                String token = auditService.accessToken();
                json = auditService.createAudit(token, jxiDhl);
            } else if (schemaCode.equals("sf3g327087wkcxxo45d9zqu77") && methodName.equals("library")) {
                json = wmsService.insertWms(param);
            } else if (schemaCode.equals("D001062chuku") && methodName.equals("master")) {
                json = wmsService.intsercome(param);
            } else if (schemaCode.equals("D001062CPTB") && methodName.equals("addItemInfo")) {
                System.out.println("添加商品");
                json = itemManage.addItemInfo(param);
            } else if (schemaCode.equals("Unit") && methodName.equals("master")) {
                System.out.println("添加单位");
                json = unitService.UnitSave(param);
            } else if (schemaCode.equals("D001062maintype") && methodName.equals("addMainType")) {
                System.out.println("添加商品主分类");
                json = itemManage.addMainType(param);
            } else if (schemaCode.equals("D001062class") && methodName.equals("addItemType")) {
                System.out.println("添加商品二级分类");
                json = itemManage.addItemType(param);
            }
            System.out.println("打印返回结果：" + json);
            return "{\"Code\": \"1\",\"Message\": \"调用测试接口成功\"}";
        } catch (Exception e) {
            System.out.println(e);
            return "{\"Code\": \"-1\",\"Message\": \"调用测试接口失败\"}";
        }
    }

    public static void main(String[] args) {
//        CommonService commonService = new CommonServiceImpl();
//        commonService.Invoke("", "D001062CPTB", "addItemInfo", "{\"chuanyunid\":\"975c6854-2b79-4573-bfda-5df063a1b9c3\",\"itemName\":\"测试商品\",\"discription\":\"测试数据\",\"memo\":\"测试数据\",\"itemMainType\":\"dbd1f4d6-5df4-498c-8e24-bf056ec8bd95\",\"itemType\":\"fa3554c1-66e5-40af-99bc-89ba74c9e14c\",\"unit\":\"55a8553a-89c5-4d69-8660-05af8f4637bd\",\"brand\":\"76e9be11-2c44-4f6d-9ea2-4627e0b71ac7\"}");
    }
}

