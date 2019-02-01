package com.cxt.ikuai.model;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class ACLManage {
	public  JSONObject GetBPAclJson(String id, String action) {
	    JSONObject object = new JSONObject();
	    object.put("func_name","acl");
	    object.put("action",action);
	    JSONObject object2 = new JSONObject();
	    object2.put("id", id);
	    Map<String,JSONObject> jsons = new HashMap<String,JSONObject>();
	    object.put("param",object2);
	    return object;
	}
	public  JSONObject GetShowAclJson() {
	    JSONObject object = new JSONObject();
	    object.put("func_name","acl");
	    object.put("action","show");
	    JSONObject object2 = new JSONObject();
	    object2.put("TYPE","total,data");
	    object2.put("limit", "0,20");
	    object2.put("ORDER_BY", "");
	    object2.put("ORDER", "");
	    Map<String,JSONObject> jsons = new HashMap<String,JSONObject>();
	    object.put("param",object2);
	    return object;
	}
}
