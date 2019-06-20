package com.example.demo1;

import com.example.demo.JacksonHelper;
import com.example.demo.Query;
import com.example.entity.*;
import com.example.pojo.PinYinUtil;
import com.example.service.AuditService;
import com.example.service.impl.AuditServiceImp;
import com.example.service.wms.ItemManage;
import com.example.service.wms.WmsService;
import com.example.service.wms.impl.ItemManageImpl;
import com.example.service.wms.impl.WmsServiceimp;
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
    public static AuditService auditService=new AuditServiceImp();


    public  static WmsService wmsService=new WmsServiceimp();

    @Autowired
    public static ItemManage itemManage = new ItemManageImpl();

    @Override
    public String GetSchema(String schemaCode) {
        System.out.println(schemaCode);
        return " {\"Code\":\"D001062ceshi2\",\"Items\":[{\"Name\":\"F0000001\",\"DisplayName\":\"单行文本\",\"DataType\":\"String\"},]}";
    }

    @Override
    public String GetSchemaList() {
        return  "{\"customer\": \"测试\",\"D001062ceshi2\": \"测试\"}";
    }

    @Override
    public String GetList(String userCode, String schemaCode, String filter) {
        return  "{\"Code\":\"0\",\"Message\":\"获取数据成功\",\"Schema\":{\"Code\":\"D001062ceshi2\",\"Items\":[{\"name\":\"F0000001\",\"DisplayName\":\"单行文本\",\"DataType\":\"String\"}],},\"Data\":[\"F0000001\":\"c而是\"]}";

    }

    @Override
    public String Invoke(String userCode, String schemaCode, String methodName, String param) {
        System.out.println(param);
        try {
            if(schemaCode.equals("D001062htkp")&& methodName.equals("Getexpress")){
                Query  dui=new Query();
                JxiDhl jxiDhl=JacksonHelper.fromJSON(param,JxiDhl.class);
                String com = PinYinUtil.ToPinyin(jxiDhl.getCom().toString());
                String  num=jxiDhl.getNum();
                String  objectid=jxiDhl.getObjectid();
                System.out.println(com);
                kuaidix  kd=dui.fanhuineiro(num,com,objectid);
            }else if(schemaCode.equals("D001062cost")&&methodName.equals("Auditr")){
                System.out.println(param);
                Cost  jxiDhl= JacksonHelper.fromJSON(param,Cost.class);
                String  token=auditService.accessToken();
                String  sdd=auditService.createAudit(token,jxiDhl);
                System.out.println(sdd);
            }else if(schemaCode.equals("sf3g327087wkcxxo45d9zqu77")&&methodName.equals("library")){
                String  json=wmsService.insertWms(param);
            }else if(schemaCode.equals("D001062chuku")&&methodName.equals("master")){
                String  json=wmsService.intsercome(param);
            }else if(schemaCode.equals("D001062CPTB")&&methodName.equals("addItemInfo")){
                String json = itemManage.addItemInfo(param);
            }
            return  "{\"Code\": \"1\",\"Message\": \"调用测试接口成功\"}";
        }catch (Exception e){
            System.out.println(e);
            return  "{\"Code\": \"-1\",\"Message\": \"调用测试接口失败\"}";
        }
    }
}

