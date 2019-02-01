package com.cxt.ikuai.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.cxt.ikuai.view.Index;

/**
 * 注释的语句都是一些测试和附加功能，可删除
 * url都是通过httpwatch捕获的
 * cookie都是通过fiddler抓取的
 * @author Administrator
 *
 */
public class JavaHttpHandle{
	

	
	//Post请求
	public void sendGet(String urlAddress,String cookie){
		try {
			//建立连接并发送请求
			HttpURLConnection urlConnection = null;
			URL url = new URL(urlAddress);
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setConnectTimeout(5000);
			urlConnection.setReadTimeout(5000);
			urlConnection.setRequestMethod("GET");
			urlConnection.setUseCaches(false);
			//这里Cookie的值每次清除后，都会更新
			urlConnection.setRequestProperty("Cookie", cookie);
			urlConnection.connect();
			
			
			//获取相应的内容
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	HttpURLConnection urlConnection = null;
	public String sendPost(String urlAddress,String cookie,JSONObject paramValue){
		try{
			//建立连接并发送请求
			URL url = new URL(urlAddress);
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setConnectTimeout(5000);
			urlConnection.setReadTimeout(5000);
			urlConnection.setUseCaches(false);
			//传入cookie
			urlConnection.setRequestProperty("Cookie", cookie);
			urlConnection.connect();
			//将参数paramValue传入
			
			String s = paramValue.toString();
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(), "utf-8");
			out.write(s);
			out.flush();

			//System.out.println("server response status:"+urlConnection.getResponseMessage());
			//获取相应的内容
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
			String line = br.readLine();
			while(line!=null){
				return line;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void sendPost(String urlAddress,String paramValue){
		try{
			//建立连接并发送请求
			URL url = new URL(urlAddress);
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setConnectTimeout(5000);
			urlConnection.setReadTimeout(5000);
			urlConnection.setUseCaches(false);
			//传入cookie
			urlConnection.setRequestProperty("Cookie", paramValue);
			urlConnection.connect();
			//将参数paramValue传入
			PrintWriter pw = new PrintWriter(urlConnection.getOutputStream());
			pw.print(paramValue);
			pw.flush();
			//System.out.println("server response status:"+urlConnection.getResponseCode());
			//获取相应的内容
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				if(line.equals("{\"Result\":10000,\"ErrMsg\":\"Succeess\"}"))
				{
					System.out.println("获得摘要认证，第一次登陆加密页面！");
				}
				line = br.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getCookie(){
			//建立连接并发送请求
			Map<String,List<String>> map = urlConnection.getHeaderFields();
			System.out.println(map);
			List<String> list = (List<String>)map.get("Set-Cookie");
			for(int i = 0; i < list.size(); i++){
				String temp = list.get(i).toString();
				String value[] = temp.split(";");
				return value[0];
			}
		return null;
	}
	public String getStatus(){
		Map<String,List<String>> map = urlConnection.getHeaderFields();
		System.out.println(map);
	return null;
	}
}
