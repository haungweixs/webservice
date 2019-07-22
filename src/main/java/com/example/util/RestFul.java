package com.example.util;

import com.example.config.Constant;
import com.example.demo.JacksonHelper;
import com.example.entity.user.Userinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by LiWeijie
 * 19/04/12 9:48
 */
public class RestFul {
    //post请求
    public   static   String  RestFulPost(String targetURl,String input)
    {
        try {
            URL restServiceURL = new URL(targetURl);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            //打开输出开关
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);

            //传递参数
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpConnection.getInputStream())));
            String output;
//            System.out.println("Output from Server:\n");
            String  sb="";
            while ((output = responseBuffer.readLine()) != null) {
//                System.err.println(output);
                sb+=output;
            }
            httpConnection.disconnect();
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            return  "false";
        }
    }
    //get请求
    public   static   String  RestFulGet(String targetURl,String input)
    {
        try {
            URL restServiceURL = new URL(targetURl);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");

            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            String output;
            System.out.println("Output from Server:  \n");
            String  json="";
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
                json+=output;
            }
            httpConnection.disconnect();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return  "false";
        }
    }

    //get请求带token方法
    public   static   String  RestFulGetToken(String targetURl,String input,String token)
    {
        try {
            URL restServiceURL = new URL(targetURl+input);
            System.out.println(targetURl+input);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("access-token",token);
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            String output;
            System.out.println("Output from Server:  \n");
            String  json="";
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
                json+=output;
            }
            httpConnection.disconnect();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return  "false";
        }
    }



    public  static   String  RestFulPostToekn(String targetURl,String input,String token){
        try {
            URL restServiceURL = new URL(targetURl);
            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("access-token",token);
            //打开输出开关
            httpConnection.setDoOutput(true);
            httpConnection.setDoInput(true);

            //传递参数
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpConnection.getInputStream())));
            String output;
//            System.out.println("Output from Server:\n");
            String  sb="";
            while ((output = responseBuffer.readLine()) != null) {
//                System.err.println(output);
                sb+=output;
            }
            httpConnection.disconnect();
            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            return  "false";
        }
    }

    //访问系统以及相关api接口的token
    public static String accToken() {
        try {
            String input = "\n" + "{\"account\": \"13685133739\",\"password\": \"123456\",\"validateCode\": \"string\"}";
            String  userjson=RestFul.RestFulPost(Constant.URL_POST_TOKEN,input);
            Userinfo jxiDhl=new Userinfo();
            if(userjson!="false"){
                jxiDhl= JacksonHelper.fromJSON(userjson,Userinfo.class);
            }
            return jxiDhl.getData().getToken();
        } catch (Exception e) {
            e.printStackTrace();
            return  "false";
        }
    }

    public static void main(String[] args) {
       String token= accToken();
        System.out.println(token);
    }
}
