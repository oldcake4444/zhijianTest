package com.test.db.Util;

import java.io.IOException;
import java.util.logging.Logger;

import com.test.Util.FileUtil;
import com.test.Util.GetConfigProperties;

public class DbQuery {
	
	static Logger log = Logger.getLogger("DbQuery.class");
	private static String dbConfigPath = "/Configuration/db.properties";
	
	public static String dbQuery(String queryFilePath) throws IOException {
		String query = FileUtil.readFile(GetConfigProperties.getValue(dbConfigPath, queryFilePath));
		return query;
	}

}
