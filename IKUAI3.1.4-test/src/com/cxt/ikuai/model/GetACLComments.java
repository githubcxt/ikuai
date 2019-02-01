package com.cxt.ikuai.model;

import org.json.JSONArray;
import org.json.JSONObject;


public class GetACLComments {
	public static String[] getComments(String status){
		JSONObject jsonouter = new JSONObject(status);
		jsonouter = (JSONObject)jsonouter.get("Data");
		JSONArray ja = (JSONArray)jsonouter.get("data");
		String []s = new String[ja.length()+1];
		for(int i = 1; i <= ja.length(); i++){
			s[i] = ja.getJSONObject(i-1).get("comment").toString();
		}
	return s;
	}
}
