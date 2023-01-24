package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetLocator {

	/**
	 * This method reads OR.properties file and returns the locator for specified
	 * key
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 */
	public static String of(String locatorKey) {
		return readProperty("src/main/resources/OR.properties" ,locatorKey);
	}

	/**
	 * 
	 * @param filePath
	 * @param locatorKey
	 * @return
	 */
	public static String readProperty(String filePath, String locatorKey) {
		String value;
		String baseDir = System.getProperty("user.dir");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(baseDir + filePath);
		} catch (FileNotFoundException e) {
			System.err.println("Object Repository not found");
		}

		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			System.err.println("Unable to process file");
		}

		value = properties.getProperty(locatorKey);

		return value;
	}


}
