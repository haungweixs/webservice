package com.example.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

import com.example.config.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpClient {
	
	private static Log log =  LogFactory.getLog(HttpClient.class);
	
	public static String postData(String requestStr,String uri,String charset,String dateTime){
		log.info("request url is :"+uri);
		log.info("requestStr is:"+requestStr);
		HttpURLConnection urlcon=null;
		InputStream in = null;
		OutputStream out = null;
		String result = null;
		try {
			URL url = new URL(uri);  
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("POST");  
			// 设置通用的请求属性
			urlcon.setRequestProperty("accept", "*/*");
			urlcon.setRequestProperty("connection", "Keep-Alive");
			urlcon.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			urlcon.setRequestProperty("Content-Type", "application/json");
			//拼接Authorization
			final Base64.Decoder decoder = Base64.getDecoder();
			final Base64.Encoder encoder = Base64.getEncoder();
			final String text = Constant.accountSid+":"+dateTime;
			System.out.println(text);
			final byte[] textByte = text.getBytes("UTF-8");
			final String encodedText = encoder.encodeToString(textByte);
			System.out.println(encodedText);
			urlcon.setRequestProperty("Authorization",encodedText);
			System.out.println(dateTime);

			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
            urlcon.connect();// 获取连接  
            out = urlcon.getOutputStream();
            out.write(requestStr.getBytes(charset));
            out.flush();
			in = urlcon.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer bs = new StringBuffer();
			String line = null;
			while ((line = buffer.readLine()) != null) {
				bs.append(line);
				}
			result = bs.toString(); 
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (null!=in)
					in.close();
				if (null!=out)
					out.close();
				if (null!=urlcon)
					urlcon.disconnect();
				}catch (Exception e1){
					
			}
		}
		return result;
	}
	
	public static String postDataHttps(String requestStr,String uri,String charset){		
		String result = "";
		BufferedReader in = null;
		HttpsURLConnection connection = null;
		DataOutputStream outStream = null;
		try {
			byte[] xmlbyte = requestStr.getBytes(charset);
			System.out.println("POST请求的URL为："+uri);
			System.out.println("POST请求的Json为："+requestStr);
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL realUrl = new URL(uri);

			connection = (HttpsURLConnection) realUrl.openConnection();
			connection.setSSLSocketFactory(sc.getSocketFactory());
			connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "application/json");
			// 建立实际的连接

			outStream = new DataOutputStream(connection.getOutputStream());

			double dd = System.currentTimeMillis();
			outStream.write(xmlbyte);
			outStream.flush();
			outStream.close();

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			// System.out.println("获取的结果为："+result);
			System.out.println("1 is :" + (System.currentTimeMillis() - dd));
			System.out.println("Retuen string is :" + result);
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {

			}

		} catch (Exception e) {
			System.out.println("发送请求出现异常！" + e);
			 e.printStackTrace();

		}
		// 使用finally块来关闭输入流
		finally {
			try{
				if (null!=in)
					in.close();
				if (null!=outStream)
					outStream.close();
				if (null!=connection)
					connection.disconnect();
				}catch (Exception e1){
					
			}
		}
		return result;
	}
	
	public static String getDataHttps(String uri,String charset){		
		String result = "";
		BufferedReader in = null;
		HttpsURLConnection connection = null;
		DataOutputStream outStream = null;
		try {
//			byte[] xmlbyte = requestStr.getBytes(charset);
			System.out.println("GET请求的URL为："+uri);
//			System.out.println("GET请求的Json为："+requestStr);
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL realUrl = new URL(uri);

			connection = (HttpsURLConnection) realUrl.openConnection();
			connection.setSSLSocketFactory(sc.getSocketFactory());
			connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestProperty("Content-Type", "application/json");
			// 建立实际的连接

			outStream = new DataOutputStream(connection.getOutputStream());

			double dd = System.currentTimeMillis();
//			outStream.write(xmlbyte);
			outStream.flush();
			outStream.close();

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			// System.out.println("获取的结果为："+result);
			System.out.println("1 is :" + (System.currentTimeMillis() - dd));
			System.out.println("Retuen string is :" + result);
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {

			}

		} catch (Exception e) {
			System.out.println("发送请求出现异常！" + e);
			 e.printStackTrace();

		}
		// 使用finally块来关闭输入流
		finally {
			try{
				if (null!=in)
					in.close();
				if (null!=outStream)
					outStream.close();
				if (null!=connection)
					connection.disconnect();
				}catch (Exception e1){
					
			}
		}
		return result;
	}
	
	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	public void test(){
//		String url = "https://35.1.36.15/westAirEpiccPort";
		String url = "https://35.1.32.94/westAirEpiccPort";
		String xml = "{\"cusCertNo\":\"510212195711163113\",\"cusName\":\"梅贵荣\"}";
		String result = postDataHttps(xml, url, "utf-8");
		System.out.print(result);
	}

}
