package com.cxt.ikuai.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class AdminPropertyReader {
	private static Properties prop = new Properties();
	private final static String file = "resource/Ikuai_Client_Admin.properties";
	static{
		try {
			InputStream in = null;
			in = new BufferedInputStream(new FileInputStream(file));
			prop.load(new InputStreamReader(in, "UTF-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
	public static void setProperty(String key, String value){
		prop.setProperty(key, value);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos, null);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
