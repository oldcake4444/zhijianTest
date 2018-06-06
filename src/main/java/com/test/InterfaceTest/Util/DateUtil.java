package com.test.InterfaceTest.Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

import org.junit.Test;

public class DateUtil {
	
	static Logger log = Logger.getLogger("DateUtil.class");
	
	private static String configPath = "/Configuration/GUI_zhijian.properties";
	
	public static ArrayList<String> getPreDay(int day) {	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		ArrayList<String> dayList = new ArrayList<String>(); 
		int startDay = 0 - day;
		
		for(int i = startDay; i<0; i++) {
			Calendar todayCalendar = Calendar.getInstance();
			todayCalendar.add(Calendar.DATE, i);
			String dayVal = sdf.format(todayCalendar.getTime());

			if (dayVal.startsWith("0")) {
				dayVal = dayVal.substring(1);
				if (dayVal.contains("/0")) {
					String dayRaw[] = dayVal.split("/");
					String trueDay = dayRaw[1].substring(1, dayRaw[1].length());
					dayVal = dayRaw[0] + "/" + trueDay;
				}
			} else if (!dayVal.startsWith("0") && dayVal.contains("/0")) {
				String dayRaw[] = dayVal.split("/");
				String trueDay = dayRaw[1].substring(1, dayRaw[1].length());
				dayVal = dayRaw[0] + "/" + trueDay;
			}
			
			dayList.add(dayVal);
		}
		
		return dayList;
		
		
	}
	
	@Test
	public void testGetPreDay() {
		ArrayList<String> dayList = getPreDay(3);
		for(int i=0; i < dayList.size(); i++) {
			System.out.println(dayList.get(i));
		}
	}

}
