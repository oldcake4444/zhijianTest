package com.test.InterfaceTest.TextHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.test.InterfaceTest.Util.FileUtil;

public class TextHandling {
	
	static Logger log = Logger.getLogger("TextHandling.class");
	
	public static HashMap<String, Integer> wordCount(String fileName) {
		String rawText = FileUtil.readFile(fileName).trim();
		String rawTextReplace = rawText.replace("\n", " ").replace("\r", " ").replace("  ", " ");
		String[] wordList = rawTextReplace.split(" ");
		HashMap<String, Integer> wordMapping = new HashMap<String, Integer>();
		int count = 0;
		List<String> wordArray = new ArrayList<String>();
		for (String word : wordList) {
			if(!wordArray.contains(word)){
				wordArray.add(word);
				wordMapping.put(word, 0);
			}
		} 
		for (String word : wordList) {
			for (String key : wordMapping.keySet()) {
				if (word.equals(key)) {
					count = wordMapping.get(key) + 1;
					wordMapping.put(key, count);
				}
			}
		}	
		return wordMapping;
	}
	
	public static HashMap<String, Integer> charCount(String fileName) {
		String rawText = FileUtil.readFile(fileName).trim();
		String rawTextReplace = rawText.replace("\n", "").replace("\r", "");
		String[] charList = new String[rawTextReplace.length()];
		List<String> charArray = new ArrayList<String>();
		HashMap<String, Integer> charMapping = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < rawTextReplace.length(); i++) {
			String singleChar = rawTextReplace.substring(i, i+1);
			charList[i] = singleChar;
		}
		for (String rawChar : charList) {
			if(!charArray.contains(rawChar)) {
				charArray.add(rawChar);
				charMapping.put(rawChar, 0);
			}
		}
		for (String rawChar : charList) {
			for (String key : charMapping.keySet()) {
				if (rawChar.equals(key)) {
					count = charMapping.get(key) + 1;
					charMapping.put(key, count);
				}
			}
		}				
		return charMapping;
	}
	
	public static String stringReverse(String fileName) {
		String rawStr = FileUtil.readFile(fileName).trim();
		String newStr = "";
		for (int i = rawStr.length() - 1; i >= 0; i--) {
			String singleChar = rawStr.substring(i, i+1);
			newStr = newStr + singleChar;
		}
		
		return newStr;
		
		
	}
	
	
	
	
	@Test
	public void wordCountTest() {
		HashMap<String, Integer> wordCnt = wordCount("src/main/resources/TextPractice/WordCountText.txt");
		for (String key : wordCnt.keySet()) {
			String wordResult = key + " " + wordCnt.get(key);
			log.info(wordResult);
		}
		
		log.info("**************************************************");
		
		HashMap<String, Integer> charCnt = charCount("src/main/resources/TextPractice/CharCountText.txt");
		for (String key : charCnt.keySet()) {
			String charResult = key + " " + charCnt.get(key);
			log.info(charResult);
		}
		
		log.info("**************************************************");
		String newStr = stringReverse("src/main/resources/TextPractice/WordSequence.txt");
		log.info(newStr);
	}

}
