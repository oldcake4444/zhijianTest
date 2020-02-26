package com.test.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

public class FileUtil {
	
	static Logger log = Logger.getLogger("FileUtil.class");
	
	private static String configPath = "/Configuration/GUI_zhijian.properties";
	
    public static void copyFile(File fromFile,File toFile) throws IOException{
    	//toFile.deleteOnExit();
    	if (toFile.exists()) {
    		log.info("File exists and will remove it.");
    		toFile.delete();
    	}
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n = 0;
        while((n = ins.read(b))!= -1){
        	out.write(b, 0, b.length);
        }
        ins.close();
        out.close();	
    }
    
    public static String readFile(String fileName) {
    	File file = new File (fileName);
    	StringBuilder result = new StringBuilder();
        try{
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();    	
    }
    
    public static void saveScreenShotToNewName(File screenShot, String rawFileName) throws IOException {
    	Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String curTime = df.format(day);
		String fileName =rawFileName + "_" + curTime + ".jpg";
		FileUtil.copyFile(screenShot, new File(GetConfigProperties.getValue(configPath, "screenshot.path") + fileName));
    }
    
    public static void replaceAndwriteFile(String oldStr, String newStr, String filePath) {
    	File file = new File (filePath);
    	StringBuilder result = new StringBuilder();
        try{
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	result.append(s+System.lineSeparator());
            }
            br.close();
            String newContent = result.toString().replace(oldStr, newStr);
            Path path = Paths.get(filePath);
            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            writer.write(newContent);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }  	
    }
    
    public static void replaceAllAndwriteFile(String String1, String String2, String newString, String filePath) {
    	File file = new File (filePath);
    	StringBuilder result = new StringBuilder();
        try{
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	result.append(s+System.lineSeparator());
            }
            br.close();
            String newContent = result.toString().replaceAll(String1 + ".+?" + String2, newString);
            Path path = Paths.get(filePath);
            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            writer.write(newContent);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }  	
    }
    
	@Test
	public void testWrite() {
		replaceAndwriteFile("[spe_supervision_audit_time]", "1582688380.000", "D:\\Automation\\StsWorkSpace\\zhijianTest\\src\\main\\resources\\TestData\\ProcessEngine\\DrawingReview\\reject_drawing008_1");
		
//		String a = "\"spe_supervision_audit\":{\"audit_at\":1582611970.000,\"judgment\":\"\"";
//		log.info(a.replaceAll("\"spe_supervision_audit\":\\{.+?judgment", "spe_supervision_auditAAAAjudgment"));
		
//		replaceAllAndwriteFile(
//				"\"spe_supervision_audit\":\\{\"audit_at\"", 
//				"\"judgment\"", 
//				"\"spe_supervision_audit\":{\"audit_at\":[spe_supervision_audit_time],\"judgment\"",
//				"D:\\Automation\\StsWorkSpace\\zhijianTest\\src\\main\\resources\\TestData\\ProcessEngine\\DrawingReview\\1");


	}
    
	
    
    
}
