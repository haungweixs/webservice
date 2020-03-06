package com.example.demo;

import com.example.entity.Nerro;
import com.example.entity.kuaidix;
import com.example.service.ChuanYunService;
import com.example.service.impl.ChuanYunServiceImpl;
import com.example.util.HttpClient;
import com.example.util.HttpClientUtil;
import com.example.util.MD5;

import javax.xml.soap.SOAPException;
import java.util.HashMap;

public class Query {


//	public static void main(String[] args) throws Exception {
//
//		String param ="{\"com\":\"shunfeng\",\"num\":\"290495245789\",\"key\":\"eKaeTncp7826\"}";
//		String customer ="DE58E3E382A3198F3B56EEE0CAE640BB";  //公司编号
//		String key = "eKaeTncp7826";   //授权密钥
//		String sign = MD5.encode(param+key+customer);
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("param",param);
//		params.put("sign",sign);
//		params.put("customer",customer);
//		String resp;
//		try {
//			resp = new HttpRequest().postData("http://poll.kuaidi100.com/poll/query.do", params, "utf-8").toString();
//			kuaidix duxi=JacksonHelper.fromJSON(resp,kuaidix.class);
//			String strus=duxi.getState();
//			for (Nerro d :duxi.getData()) {
//				System.out.println(d.getContext());
//				System.out.println(d.getTime());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public   kuaidix  fanhuineiro(String com,String  num,String objectid)
	{
		String param ="{\"com\":"+com+",\"num\":"+num+",\"key\":\"eKaeTncp7826\"}";
		String customer ="DE58E3E382A3198F3B56EEE0CAE640BB";  //公司编号
		String key = "eKaeTncp7826";   //授权密钥
		String sign = MD5.encode(param+key+customer);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param",param);
		params.put("sign",sign);
		params.put("customer",customer);
		String resp;
		try {
			resp = new HttpRequest().postData("http://poll.kuaidi100.com/poll/query.do", params, "utf-8").toString();
			kuaidix duxi=JacksonHelper.fromJSON(resp,kuaidix.class);
			String strus=duxi.getState();
			 ChuanYunService chuanYunService=new ChuanYunServiceImpl();
			for (Nerro d :duxi.getData()) {
				System.out.println(d.getContext());
				System.out.println(d.getTime());
				System.out.println(objectid);
				String  massage=chuanYunService.CreateBizObject("D001062test001","{F0000001:'"+d.getTime()+"',F0000004:'"+d.getContext()+"',F0000005:'"+objectid+"'}","true");
			}
			return duxi;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		}
	}

	public static void main(String[] args) throws SOAPException {
		String param ="{\"com\":\"zhongtong\",\"num\":\"73124816022340\",\"key\":\"eKaeTncp7826\"}";
		String customer ="DE58E3E382A3198F3B56EEE0CAE640BB";  //公司编号
		String key = "eKaeTncp7826";   //授权密钥
		String sign = MD5.encode(param+key+customer);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param",param);
		params.put("sign",sign);
		params.put("customer",customer);
		String resp;
		try {
			resp = HttpClientUtil.doPost("http://poll.kuaidi100.com/poll/query.do", params).toString();
			kuaidix duxi=JacksonHelper.fromJSON(resp,kuaidix.class);
			String strus=duxi.getState();
			ChuanYunService chuanYunService=new ChuanYunServiceImpl();
			for (Nerro d :duxi.getData()) {
				System.out.println(d.getContext());
				System.out.println(d.getTime());
			}
			System.out.println(strus);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
