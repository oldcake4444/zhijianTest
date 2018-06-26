package com.test.InterfaceTest.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.junit.Test;

public class CsvHandler {
	
	static Logger log = Logger.getLogger("CsvHandler.class");
	
	public static ArrayList<String> readFromCsv(String filePath, String splitter) throws IOException {
		@SuppressWarnings("resource")		
        DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
        BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));//这里如果csv文件编码格式是utf-8,改成utf-8即可
		
        reader.readLine(); //第一行信息，为标题信息，不用,如果需要，注释掉            
        String line = null;
        
        ArrayList<String> strList = new ArrayList<String>();
        
        while((line=reader.readLine())!=null) {
        	String item[] = line.split(splitter);   //CSV格式文件为逗号分隔符文件，这里根据逗号切分 
        	for(int i = 0; i < item.length; i++) {
        		String last = item[i];  //这就是你要的数据了
        		strList.add(last);
        	}
        }
        
		return strList;	
	}
	
	public static ArrayList<String> readFromCsvByColAndRow(String filePath, String splitter, int row, int col) throws IOException {	
        DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
        BufferedReader reader= new BufferedReader(new InputStreamReader(in,"utf-8"));//这里如果csv文件编码格式是utf-8,改成utf-8即可
		
        reader.readLine(); //第一行信息，为标题信息，不用,如果需要，注释掉            
        String line = null;
        
        ArrayList<String> strList = new ArrayList<String>();
        
        int index=0;
        while((line=reader.readLine())!=null){
            String item[] = line.split(splitter);//CSV格式文件为逗号分隔符文件，这里根据逗号切分
         if(index == row-1){
             if(item.length >= col-1){
                 String last = item[col-1];//这就是你要的数据了 
                 strList.add(last);
             }
         }
         index++;
         }      
        
		return strList;	
	}
	
	
	public static void writeCsv(String filePath, ArrayList<String> inputContent, String splitter) throws IOException {       
	      File csv = new File(filePath); // CSV数据文件    
	      BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加 
	      // 添加新的数据行   
	      for(int i = 0; i < inputContent.size(); i++) {
	    	  bw.write(inputContent.get(i) + splitter); 
	      }
	      bw.newLine();
	      bw.close();    
	  }
	
	public static void writeCsv(String filePath, HashMap<String, String> inputMap, String splitter) throws IOException {       
	      File csv = new File(filePath); // CSV数据文件    
	      BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加 
	      // 添加新的数据行   
	      for(String key : inputMap.keySet()) {
	    	  bw.write(key + "," + inputMap.get(key) + splitter);
	      }
	      
	      bw.newLine();
	      bw.close();    
	  } 

	public void testWriteCsv() throws IOException {
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("I");
		strList.add("am");
		strList.add("the");
		strList.add("KING");
		writeCsv("C:\\Users\\Administrator\\Desktop\\writeTest.csv", strList, ";");
		
	}
	
	public void testReadCsv() throws IOException {
		ArrayList<String> abc = readFromCsv("src/main/resources/SquadInfo/squadInfo.csv", ";");
		for(int i = 0; i < abc.size(); i++) {
			System.out.println(abc.get(i));
		}
		System.out.println(abc.get(1));
		
	}
	
	@Test
	public void testReadCsvByColAndRow() throws IOException {
		ArrayList<String> abc = readFromCsvByColAndRow("src/main/resources/SquadInfo/squadInfo.csv", ";", 1, 4);
		for(int i = 0; i < abc.size(); i++) {
			System.out.println(abc.get(i));
		}
		
	}
	
		

        
                
		

	

}
