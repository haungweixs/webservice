package com.example.util;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/**
 * 测试调用一些meeting第三方接口 
 * @author Jack.Song
 */
public class TestMeetingInterface {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestMeetingInterface tmi = new TestMeetingInterface();
        tmi.httpsRequest("https://183.134.199.202/bchireserver","GET",null);
    }


    /**
     * 用传统的URI类进行请求 
     * @param urlStr
     */
    public void testPost(String urlStr) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");

            OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
            String xmlInfo = getXmlInfo();
            System.out.println("urlStr=" + urlStr);
//            System.out.println("xmlInfo=" + xmlInfo);   
            out.write(new String(xmlInfo.getBytes("UTF-8")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            String line = "";
            for (line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 处理https GET/POST请求
     * 请求地址、请求方法、参数
     * */
    public static String httpsRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext=SSLContext.getInstance("SSL");
            TrustManager[] tm={new MyX509TrustManager()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            conn.connect();
            //往服务器端写内容
            if(null!=outputStr){
                String xmlInfo = getXmlInfo();
                OutputStream os=conn.getOutputStream();
                os.write(xmlInfo.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }


    private static String getXmlInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<Request>");
        sb.append(" <Head>");
        sb.append("     <RequestId>readMeetingStatus</RequestId>");
        sb.append("     <RequestType>meeting</RequestType>");
        sb.append("     <RequestTime>xml</RequestTime>");
        sb.append("     <Md5Value>admin</Md5Value>");
        sb.append(" </Head>");
        sb.append(" <Body>");
        sb.append("     <MainId>43283344</MainId>");
        sb.append("     <txHash>43283344</txHash>");
        sb.append("     <Seller>43283344</Seller>");
        sb.append("     <GoodsType>电子产品</GoodsType>");
        sb.append("     <GoodsName>尼康相机</GoodsName>");
        sb.append("     <GoodsModel>D750</GoodsModel>");
        sb.append("     <Quantity>1</Quantity>");
        sb.append("     <StartTime>2018-10-15 23:23:01</StartTime>");
        sb.append("     <EndTime>2018-10-23 23:23:01</EndTime>");
        sb.append("     <alipayOrderNo>1237489274892</alipayOrderNo>");
        sb.append("     <alipayOrderPrice>100000</alipayOrderPrice>");
        sb.append("     <alipayOrderAmount>1000</alipayOrderAmount>");
        sb.append("     <alipayOrderTotalAmount>5000</alipayOrderTotalAmount>");
        sb.append("     <Price>80000</Price>");
        sb.append("     <CertName>张三</CertName>");
        sb.append("     <CertType>100</CertType>");
        sb.append("     <CertMobile>139********</CertMobile>");
        sb.append("     <BuyTime>2018-10-12 23:23:01</BuyTime>");
        sb.append("     <ConfirmTime>2018-10-15 23:23:01</ConfirmTime>");
        sb.append("     <ExtendInfos>");
        sb.append("       <***>***</***>");
        sb.append("     </ExtendInfos>");
        sb.append(" </Body>");
        sb.append("</Request>");
        return sb.toString();
    }
}