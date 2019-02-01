package com.cxt.ikuai.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cxt.ikuai.controller.ACLPropertyReader;
import com.cxt.ikuai.view.Index;

public class ARPManage {
	public  JSONObject GetAddArpJson(String ip, String mac, String comment) {
	    JSONObject object = new JSONObject();
	    object.put("func_name","arp");
	    object.put("action","add");
	    JSONObject object2 = new JSONObject();
	    object2.put("bind_type", "1");
	    object2.put("interface", "lan1");
	    object2.put("mac", mac);
	    object2.put("ip_addr", ip);
	    object2.put("comment", comment);
	    object.put("param",object2);
	    return object;
	}
	public  JSONObject GetEditArpJson(String ip, String mac, String comment,String old_ip,String id) {
		long ip_addr_int = 0;
		String rule = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pattern = Pattern.compile(rule);
		Matcher matcher = pattern.matcher(ip);
		if(matcher.matches()){
			String []arr = ip.split("\\.");
			for(int i = 0; i <= 3; i++){
				long p = Long.parseLong(arr[i]);
				ip_addr_int |= p << ((3 - i) << 3);
			}
		}else
			ip_addr_int = 0;
		JSONObject object = new JSONObject();
	    object.put("func_name","arp");
	    object.put("action","edit");
	    JSONObject object2 = new JSONObject();
	    object2.put("bind_type", "1");
	    object2.put("interface", "lan1");
	    object2.put("mac", mac);
	    object2.put("id", String.valueOf(id));
	    object2.put("ip_addr", ip);
	    object2.put("comment", comment);
	    object2.put("ip_addr_int", ip_addr_int);
	    object2.put("old_ip_addr", old_ip);
	    object.put("param",object2);
	    return object;
	}
	public static JSONObject GetShowArpJson(){
	    JSONObject object = new JSONObject();
	    object.put("func_name","arp");
	    object.put("action","show");
	    JSONObject object2 = new JSONObject();
	    object2.put("TYPE", "total,data");
	    object2.put("ORDER_BY", "ip_addr_int");
	    object2.put("orderType", "IP");
	    object2.put("ORDER", "asc");
	    object2.put("limit", "0,20");
	    object.put("param",object2);
	    return object;
	}
	public  JSONObject GetDelArpJson(String id,String ip_addr) {
	    JSONObject object = new JSONObject();
	    JSONObject object2 = new JSONObject();
	    object.put("func_name","arp");
	    object.put("action","del");
	    object2.put("id", String.valueOf(id));
	    object2.put("ip_addr", ip_addr);
	    object.put("param",object2);
	    return object;
	}
	
}