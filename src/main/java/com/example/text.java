package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.config.Constant;
import com.example.entity.NbNum;
import com.example.entity.Reader18;
import com.example.entity.Theants.Identity;
import com.example.entity.Theants.NotaryTrans;
import com.example.service.wms.WmsService;
import com.example.service.wms.impl.WmsServiceimp;
import com.example.util.*;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiWeijie
 * 19/04/10 18:12CountDetail
 */
public class text {


//    public static void main(String[] args) {
////        WmsService wmsService =new WmsServiceimp();
////        String  acctoken= RestFul.accToken();
////        System.out.println(acctoken);
//        NbNum nbNum=new NbNum();
//        nbNum.setBlack_A3(151);
//        nbNum.setBlack_A4(545);
//        nbNum.setBoxCodes("djud");
//        nbNum.setColor_A3(44);
//        nbNum.setColor_A4(445);
//        nbNum.setReadDate("dudb");
//        nbNum.setSendDate("did");
//        String  shjdbded=RestFul.RestFulPost("http://139.196.189.181:9074/nbNum",JSONObject.toJSONString(nbNum));
//        System.out.println(shjdbded);
//
//    }
    private  static  String myPrivateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMyCraxR5s65S0Vp AkorxWfiSAu0fN3WtGFg+XPv74CCQ01sDZVm9Sfbv+2VOxnBI3PFh8St+KjYNHhx 4+VArnvzzCMgUpnR+RGMnOjuTvVzl3ywE51IM9z3+rNu/MPJPAZHWOS24bRlvaOz 3geeyHipBSZ68vCBpVUa0WR7r6OhAgMBAAECgYAR4XMR1+9YL7c3EGFU3tLZrF0k ONmaA8Wtpe7phhboo3sC7+mYIHJa08nKGfwa2lohKyodtiBBkvWzejG0v50BrWHw ZwJrKKaztAsgyvEpEjzeUjOgGqu2bU82BauVoFSHR5L7cOOVenrxmcVJQDARcEyq F4cc4pmfd6Duv9WyAQJBAObCVQ/mq7SmpgZ70H6Vfa0C/fwLZi2/BfLZ8xy5B5Q8 N0sRjZH2uH9b/2ZMWBtk1wjv1kkR/WQsjRMxUAAKaJECQQDi4VZJe3hjHSYm1yl/ /TKkcw0s7knxoTMwH56YbN6cu48uksymnVGWetYKmmWNKMN5Y2QznKogITYO7zsj nJIRAkEAntPbIFqwjGK3m3bVBot2OQL6NeTSq2HzgjepMXfZU5oupKisPG8IhgCY RZz+d7xslWYeo6SSN8TCRReH7L89QQJASR8a8j/rAvaoDyiVZXyzT7EM9AgwqMGt f7sRIEsmTBlfAkGp16EoZHledrhgNmiG556S8tdxNT2+8H1F8CpMIQJBAKb7cv19 wgzf6rfcB7zkimRncLFYaSHTOBm/F2V6qKXHC2qh2ExLS5oZXuDTi3xaQPor1Z0J Q/Q8LZFsMDUgMkY=";

//    public static void main(String[] args) throws Exception {
//        String url = "https://35.1.32.94/westAirEpiccPort";
//        String xml = "{\"cusCertNo\":\"510212195711163113\",\"cusName\":\"梅贵荣\"}";
//        String result = HttpClient.postDataHttps(xml, url, "utf-8");
//        System.out.print(result);
//    }

    public  void  BaoDan()
    {
        String url = "https://35.1.32.94/westAirEpiccPort";
        String xml = "{\"cusCertNo\":\"510212195711163113\",\"cusName\":\"梅贵荣\"}";
        String result = HttpClient.postDataHttps(xml, url, "utf-8");
        System.out.print(result);
    }

    public  void  CunZe() throws Exception {
        CertUtil certUtil=new CertUtil();
        String accountId = "notary_test"; // 您的账号ID
        String bizid = String.valueOf(2); // 业务类型，具体可参考 [附录](~~~~)
        String timestamp = String.valueOf(System.currentTimeMillis()); // 获取当前时间
        String privateKey = myPrivateKey; // ⽤户私钥
        String plain = accountId+bizid+timestamp; // 此接⼝的签名规则
        String signedData = certUtil.sign(plain,privateKey); // signedData即为签名后的值

        Identity identity=new Identity();
        identity.setUserType("PERSON");
        identity.setCertType("IDENTITY_CARD");
        identity.setCertName("唐耀祥");
        identity.setCertNo("4545454554894888");
        String customerStr =JacksonHelper.toJSON(identity);
        byte[] data = customerStr.getBytes();
        byte[] encodedData = certUtil.encryptByPrivateKey(data, privateKey);
        //resultBase64String为我们的⽬标值
        String resultBase64String = new String(Base64.getEncoder().encode(encodedData), StandardCharsets.UTF_8);

        NotaryTrans notaryTrans=new NotaryTrans();
        notaryTrans.setAccountId(accountId);
        notaryTrans.setBizId(Integer.valueOf(bizid));
        notaryTrans.setSubBizId("HOUSERENTING");
        notaryTrans.setCustomer(resultBase64String);
        notaryTrans.setProperties("123454dffb");
        notaryTrans.setTimestamp(timestamp);
        notaryTrans.setSignedData(signedData);
        notaryTrans.setTsr(false);
        String json=JacksonHelper.toJSON(notaryTrans);
        String sd=HttpRequestUtil.Post("http://47.110.19.106/api/notaryTrans",json);
        System.out.println(sd);
    }
}
