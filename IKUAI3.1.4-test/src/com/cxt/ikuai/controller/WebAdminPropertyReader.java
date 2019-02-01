package com.cxt.ikuai.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class WebAdminPropertyReader {
	private static Properties prop = new Properties();
	private final static String file = "C:/Windows/System32/Ikuai_Web_Admin.properties";
	static{
		try {
			InputStream in = null;
			in = new BufferedInputStream(new FileInputStream(file));
			prop.load(new InputStreamReader(in, "utf-8"));
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
}
