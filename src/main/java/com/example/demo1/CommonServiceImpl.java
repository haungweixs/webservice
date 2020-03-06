package com.example.demo1;

import com.example.demo.JacksonHelper;
import com.example.demo.Query;
import com.example.entity.*;
import com.example.pojo.PinYinUtil;
import com.example.service.AuditService;
import com.example.service.Messge.CCPRestSDKService;
import com.example.service.Messge.impl.CCPRestSDKimplService;
import com.example.service.UnitService;
import com.example.service.impl.AuditServiceImp;
import com.example.service.impl.UnitServiceImp;
import com.example.service.wms.*;
import com.example.service.wms.impl.*;
import com.example.util.CyCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.text.ParseException;

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

    public static UnitService unitService = new UnitServiceImp();

    public WareInfoServer wareInfoServer=new WareInfoServerImpl();

    public ItemeasServer itemeasServer=new ItemeasServerimpl();

    public SupplierManageService supplierManageService = new SupplierManageServiceImpl();

    public CCPRestSDKService ccpRestSDKService=new CCPRestSDKimplService();

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
            } else if(schemaCode.equals("D001062CPTB") && methodName.equals("updateItemInfo")){
                json = itemManage.updateItemInfo(param);
            } else if (schemaCode.equals("Unit") && methodName.equals("master")) {
                System.out.println("添加单位");
                json = unitService.UnitSave(param);
            } else if (schemaCode.equals("D001062maintype") && methodName.equals("addMainType")) {
                System.out.println("添加商品主分类");
                json = itemManage.addMainType(param);
            } else if (schemaCode.equals("D001062class") && methodName.equals("addItemType")) {
                System.out.println("添加商品二级分类");
                json = itemManage.addItemType(param);
            }else if(schemaCode.equals("brand") && methodName.equals("addBrand")){
                System.out.println("添加品牌");
                json = itemManage.addBrand(param);
            }else if(schemaCode.equals("brand") && methodName.equals("updateBrand")){
                System.out.println("更新品牌");
                json = itemManage.updateBrand(param);
            }else if(schemaCode.equals("D001062class") && methodName.equals("updateItemType")){
                System.out.println("更新商品二级分类");
                json = itemManage.updateItemType(param);
            }else if (schemaCode.equals("D000030SCMWareHouse")&&methodName.equals("wareif")){
                json=wareInfoServer.saveWareInfo(param);
            }else if(schemaCode.equals("igsscmdh48fs3tl5xqrxx4tw0")&&methodName.equals("item")){
                System.out.println("添加货主");
                json=itemeasServer.ItemasSave(param);
            } else if (schemaCode.equals("D001062inventory")&&methodName.equals("getItemCount")){
                System.out.println("查询库存");
                Integer temp = itemManage.queryItemCount(param);
                json = temp.toString();
            }else if(schemaCode.equals("supplier")&&methodName.equals("addSupplier")){
                System.out.println("添加供应商");
                json=supplierManageService.addSupplier(param);
            }else if(schemaCode.equals("shujudaoru")&&methodName.equals("library")){
                json=wmsService.inshuju(param);
            }else if(schemaCode.equals("rukutiaoma")&&methodName.equals("master")){
                json=wmsService.rukutiaoma(param);
            }else if(schemaCode.equals("D002chuku")&&methodName.equals("mater")){
                json=wmsService.chukuoma(param);
            }
            else if(schemaCode.equals("chukutiaoma")&&methodName.equals("master")){
                json=wmsService.intrcome(param);
            } else if(schemaCode.equals("jiutiaoma")&&methodName.equals("rjmsde")) {
                json=wmsService.jiutiao(param);
            }else if(schemaCode.equals("clientmanage")&&methodName.equals("create")){
                json=wmsService.client(param);
            }else if (schemaCode.equals("clientmanage")&&methodName.equals("update")){
                json=wmsService.clientUpdate(param);
            }else if(schemaCode.equals("CCPRestSDK")&&methodName.equals("phone")){
                json= ccpRestSDKService.duanxinList(param);
            }
                System.out.println(json);
                return "{\"Code\": \"1\",\"Message\": \"调用测试接口成功\"}";
        } catch (Exception e) {
            System.out.println(e);
                return "{\"Code\": \"-1\",\"Message\": \"调用测试接口失败\"}";
        }
    }

    public static void main(String[] args) throws ParseException {
          String json="{\"Successful\":true,\"ErrorMessage\":null,\"Logined\":false,\"ReturnData\":{\"BizObjectId\":\"47d2ce87-cbcc-4cb4-a189-d0dde797bdbf\"},\"DataType\":0}";
//        TiaoMa tiaoMa=JacksonHelper.fromJSON(json,TiaoMa.class);
//        String js= JSONObject.toJSONString(tiaoMa);
//        String  shjdbded=RestFul.RestFulPostToekn(Constant.URL_POST_MASTER_CHUTIAOMA,js,RestFul.accToken());
//        System.out.println(shjdbded);
          CyCallBack jsd= JacksonHelper.fromJSON(json,CyCallBack.class);
          System.out.println(jsd.getReturnData().getBizObjectId());
    }
}

