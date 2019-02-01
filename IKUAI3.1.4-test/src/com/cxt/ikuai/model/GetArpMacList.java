package com.cxt.ikuai.model;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cxt.ikuai.view.Index;

public class GetArpMacList {
	public String[] GetMacList(String status){
		JSONObject jsonouter = new JSONObject(status);
		jsonouter = (JSONObject)jsonouter.get("Data");
		JSONArray ja = (JSONArray)jsonouter.get("data");
		String []s = new String[ja.length()];
		for(int i = 0; i < ja.length(); i++){
			s[i] = ja.getJSONObject(i).get("mac").toString();
		}
		return s;
	}
}
