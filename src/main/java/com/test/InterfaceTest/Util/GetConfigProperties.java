package com.test.InterfaceTest.Util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Test;

public class GetConfigProperties {
	
	static Logger log = Logger.getLogger("GetConfigPorperties.class");
	
	public static String getValue(String propertyPath, String key) throws IOException {
		Properties prop = new Properties();
		String value = null;		
		try {
			prop.load(new InputStreamReader(Object.class.getResourceAsStream(propertyPath), "UTF-8"));
		    value = prop.get(key).toString();
		} catch (FileNotFoundException e) {
			log.info("Can't find the property file");
		}
		return value;
	}
	
	public static String setValue(String propertyPath, String propertyFullPath, String key, String val) throws IOException {
		Properties prop = new Properties();
		String value = null;		
		try {
			prop.load(new InputStreamReader(Object.class.getResourceAsStream(propertyPath), "UTF-8"));
			
			
			
//			OutputStream fos = new FileOutputStream(propertyFullPath); 
			OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(propertyFullPath), "utf-8");
			
		    prop.setProperty(key, val);
		    prop.store(oStreamWriter, "Update Done!");
		    oStreamWriter.close();
		} catch (FileNotFoundException e) {
			log.info("Can't find the property file");
		}
		return value;
	}
	
	@Test
	public void testGetProperties() throws IOException {
			log.info(getValue("/Configuration/GUI_zhijian.properties", "prod"));
	}

}
