package com.test.InterfaceTest.Util;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

import net.sf.json.JSONObject;


public class ApiShareSteps {
	
	static Logger log = Logger.getLogger("ApiShareSteps.class");
	
	private static String configPath = "/Configuration/AppApi_zhijian.properties";
	
	public static String deviceIdGenerator() throws IOException {
		String numLengthStr = GetConfigProperties.getValue(configPath, "deviceIdLength");		
		int numLength = Integer.valueOf(numLengthStr);
		Random rm = new Random();  
	    // 获得随机数  
	    int pross1 = (int) ((1 + rm.nextDouble()) * Math.pow(10, numLength/2)); 
	    int pross2 = (int) ((1 + rm.nextDouble()) * Math.pow(10, numLength/2));
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross1) + String.valueOf(pross2);  	    
	    String deviceId = fixLenthString.substring(1, numLength + 1);
	    // 返回固定的长度的随机数  
	    return deviceId;
	}
	
	public static JSONObject strToJson(String str) {
		JSONObject json = JSONObject.fromObject(str);  
		return json;
		
	}
	
//	@Test
//	public void testDeviceIdGenerator() throws IOException {
//		log.info(deviceIdGenerator());
//	}

}
