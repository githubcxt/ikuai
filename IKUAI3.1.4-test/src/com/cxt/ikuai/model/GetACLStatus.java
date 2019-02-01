package com.cxt.ikuai.model;


import org.json.JSONArray;
import org.json.JSONObject;

import com.cxt.ikuai.controller.ACLPropertyReader;

public class GetACLStatus {
	public static int getStatus(String status, String remark, String id_index){
		JSONObject jsonouter = new JSONObject(status);
		jsonouter = (JSONObject)jsonouter.get("Data");
		JSONArray ja = (JSONArray)jsonouter.get("data");
		for(int i = 0; i < ja.length(); i++){
			if(ja.getJSONObject(i).get("comment").equals(remark)){
				String s = ja.getJSONObject(i).get("id").toString();
				ACLPropertyReader.setProperty("id_"+id_index, ja.getJSONObject(i).get("id").toString());
				if(ja.getJSONObject(i).get("enabled").toString().equals("yes"))
					return 1;
				else
					return 0;
			}
		}
		return -1;
	}
}
