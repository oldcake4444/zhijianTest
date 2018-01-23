package com.test.InterfaceTest.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.junit.Test;

public class FileUtil {
	
	static Logger log = Logger.getLogger("FileUtil.class");
	
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
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
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
    
    
}
