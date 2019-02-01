package com.cxt.ikuai.model;

import com.cxt.ikuai.model.MyURL;

public class MyURL {
	public static MyURL myurl;
	public static String initial_login = "http://192.168.1.1/";
	public static  String Action_login = "http://192.168.1.1/Action/login";
	public static  String index = "http://192.168.1.1/#/system-overview";
	public static  String ACLindex = "http://192.168.1.1/#/firewall/acl";
	public static  String ACLManage = "http://192.168.1.1/Action/call";
	public static  String page_data="http://192.168.1.1/Action/call";
	
	public static MyURL getMyURL(){
		if(myurl==null){
			myurl = new MyURL();
		}
		return myurl;
	}
}
