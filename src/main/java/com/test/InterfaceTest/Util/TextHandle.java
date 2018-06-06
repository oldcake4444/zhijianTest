package com.test.InterfaceTest.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TextHandle {
	
	Logger log = Logger.getLogger("TextHandling.class");
	
	private String configPath = "/Configuration/accountName.properties";
	private String configFullPath = "src/main/resources/Configuration/accountName.properties";
	
	public static String[] getNewAcntName(String acntConfigPath, String acntConfigFullPath, int seqNo) throws IOException {
		String curAcntName = GetConfigProperties.getValue(acntConfigPath, "latestAcntName");
		String acntseqNoStr = curAcntName.substring(Integer.valueOf(GetConfigProperties.getValue(acntConfigPath, "nameLen")), curAcntName.length());
		String newSeqNoStr = String.valueOf(Integer.valueOf(acntseqNoStr) + seqNo);
		String newAcntName = curAcntName.substring(0, Integer.valueOf(GetConfigProperties.getValue(acntConfigPath, "nameLen"))) + newSeqNoStr;
		GetConfigProperties.setValue(acntConfigPath, acntConfigFullPath, "latestAcntName", newAcntName);
		
		String curRealName = GetConfigProperties.getValue(acntConfigPath, "realName");
		String newRealName = curRealName + newSeqNoStr;
		
		String acntInfo[] = {newAcntName, newRealName};
		
		return acntInfo;
	}
	
	public static void updatePropAcntName(String acntConfigPath, String acntConfigFullPath, String newAcntName) throws IOException {
		GetConfigProperties.setValue(acntConfigPath, acntConfigFullPath, "latestAcntName", newAcntName);
	}
	
	
	@Test
	public void testGetNewAcntName() throws IOException {
		String acntInfo[] = getNewAcntName(this.configPath, this.configFullPath, 1);
		for (int i = 0; i < acntInfo.length; i++) {
			log.info(acntInfo[i]);
		}
	}

}
