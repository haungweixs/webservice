package com.example.demo;

import com.example.entity.Nerro;
import com.example.entity.kuaidix;
import com.example.service.ChuanYunService;
import com.example.service.impl.ChuanYunServiceImpl;
import com.example.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;

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
		String param ="{\"com\":\"shunfeng\",\"num\":\"290495245789\",\"key\":\"eKaeTncp7826\"}";
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
				String  massage=chuanYunService.createBizObject("D001062test001","{F0000001:'"+d.getTime()+"',F0000004:'"+d.getContext()+"',F0000005:'"+objectid+"'}",true);
			}
			return duxi;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  null;
		}
	}

	public static void main(String[] args) throws SOAPException {
		ChuanYunService chuanYunService=new ChuanYunServiceImpl();
//		String  json=chuanYunService.loadBizObject("D001062chuku","51da85d8-935f-491d-a56c-d5665ec1b6bc");
//		String  json=chuanYunService.updateBizObject("bff0c6ozpa26by0rqj16eh7i1","{F0000159:'已出库'}","65fc4600-000d-4aaa-aaa5-9be603eabcf7");
		String  json=chuanYunService.loadBizObjects("bff0c6ozpa26by0rqj16eh7i1","{\"FromRowNum\":-1,\"ToRowNum\":1000,\"Matcher\":{\"Type\":\"And\",\"Matchers\":[{\"Type\":\"And\",\"Matchers\":[{\"Type\":\"Item\",\"Name\":\"SeqNo\",\"Operator\":8,\"Value\":\"DZ20190410002\"}]},]},\"SortByCollection\":[],\"RequireCount\":false}");
		System.out.println(json);
	}
}
