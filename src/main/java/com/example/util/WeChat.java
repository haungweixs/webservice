package com.example.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by LiWeijie
 * 19/11/12 16:43
 */
public class WeChat {

        public static void main(String[] args) {
            TreeMap<String,String> map=new TreeMap<String, String>();
            map.put("service", "XXX");
            map.put("mch_id", "XXX");
            map.put("out_trade_no", "ab1406046847");
            map.put("body", "支付测试");
            map.put("total_fee", "10");
            map.put("mch_create_ip", "127.0.0.1");
            map.put("notify_url", "https://wap.tenpay.com/tenpay.asp");
            map.put("nonce_str", "adf880d5c8986bd0deb6423c92c9d948");
            System.out.println(map.keySet().toString());
            Object[] strs=(Object[]) map.keySet().toArray();
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]+"=").append(map.get(strs[i])+"&");
            }
            sb.append("key=9d101c97133837e13dde2d32a5054abb");
            String md5=MD5(sb.toString()).toUpperCase();
            map.put("sign", md5);
            try {
                post("https://网址", new String(map2XML(map),"utf8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        /**
         * 发送请求.
         * @param httpsUrl
         *            请求的地址
         * @param xmlStr
         *            请求的数据
         */
        public static void post(String httpsUrl, String xmlStr) {
            HttpsURLConnection urlCon = null;
            try {
                urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
                urlCon.setDoInput(true);
                urlCon.setDoOutput(true);
                urlCon.setRequestMethod("POST");
                urlCon.setRequestProperty("Content-Length",
                        String.valueOf(xmlStr.getBytes().length));
                urlCon.setUseCaches(false);
                urlCon.getOutputStream().write(xmlStr.getBytes("utf8"));
                urlCon.getOutputStream().flush();
                urlCon.getOutputStream().close();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        urlCon.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        //生成md532位字符串
        public static String MD5(String sourceStr) {
            String result = "";
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(sourceStr.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                result = buf.toString();
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
            return result;
        }
         //将map 转化为xml
      public static byte[] map2XML(Map map) {
            StringBuffer sb = new StringBuffer();
            sb.append("<xml>");
            map2XML(map, sb);
            sb.append("</xml>");
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private static void map2XML(Map map, StringBuffer sb) {

            Set set = map.keySet();
            for (Iterator it = set.iterator(); it.hasNext();) {
                String key = (String) it.next();
                Object value = map.get(key);
                if (null == value)
                    value = "";
                if (value instanceof List) {
                    List list = (List) map.get(key);
                    sb.append("<" + key + ">");
                    for (int i = 0; i < list.size(); i++) {
                        Map hm = (Map) list.get(i);
                        map2XML(hm, sb);
                    }
                    sb.append("</" + key + ">");

                } else if(value instanceof Set){
                    Set list = (Set) map.get(key);
                    sb.append("<" + key + ">");
                    for(Iterator it1 = list.iterator(); it1.hasNext();) {
                        Map hm = (Map) it1.next();
                        map2XML(hm, sb);
                    }
                    sb.append("</" + key + ">");
                }else {
                    if (value instanceof Map) {
                        sb.append("<" + key + ">");
                        map2XML((Map) value, sb);
                        sb.append("</" + key + ">");
                    } else {
                        sb.append("<" + key + ">" + value + "</" + key + ">");
                    }

                }

            }}
    }
