package com.test.InterfaceTest;


import org.json.JSONObject;
import org.junit.Assert;

import com.test.InterfaceTest.Util.RestassureApiCalling;

public class JsonTest {
	
	public static void main(String[] args) {
		
		String response = RestassureApiCalling.getMethod("https://devtest8.buildingqm.com", "/uc/app/login/?device_id=862460033965107&password=12345678&username=kentest40");
		//System.out.print(ApiShareSteps.strToJson(response).toString());
		
		
		JSONObject data_obj = new JSONObject(response);
		System.out.print(data_obj + "\n");
		
		JSONObject loginInfo = (JSONObject) data_obj.get("data");
		System.out.print(loginInfo + "\n");
		
		JSONObject usrInfo = (JSONObject) loginInfo.get("user");
		System.out.print(usrInfo + "\n");
		
		String realName = usrInfo.getString("real_name");
		System.out.print(realName);
		
		Assert.assertEquals("kentest40", realName);
		

//		JSONArray apps_array = new JSONArray(apps_str);
//		String[] result = new String[apps_array.length()];
//		for(int i=0;i<apps_array.length();i++){
//		    JSONObject app_obj = new JSONObject(apps_array.get(i).toString());
//		    String name = app_obj.get("name").toString();
//		    result[i] = name;
//		}
		

		
	}

}
