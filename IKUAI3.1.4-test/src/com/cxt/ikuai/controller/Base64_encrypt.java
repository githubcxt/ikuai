package com.cxt.ikuai.controller;

import org.apache.commons.codec.binary.Base64;

public class Base64_encrypt {
	public static String commonsCodeBase64(String src){
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		return new String(encodeBytes);
	}
}
