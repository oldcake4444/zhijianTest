package com.test.Util;

import java.util.logging.Logger;
import net.sf.json.JSONObject;

public class TextFormat {
	
	Logger log = Logger.getLogger("TextFormat.java");
	
	public static JSONObject stringToJsonObj (String inputString) {
		JSONObject stringToJsonObj = JSONObject.fromObject(inputString);
        //JSONObject stringToJsonObj = stringToJsonObjRaw.getJSONObject(key1);
		//JSONArray stringToJsonArr = stringToJsonObj.getJSONArray(key2);
		return stringToJsonObj;
	}

}
