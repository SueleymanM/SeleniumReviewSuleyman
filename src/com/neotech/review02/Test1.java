package com.neotech.review02;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

public class Test1 {

	public static void main(String[] args) {

		// I just read the file only one time
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		String browser = ConfigsReader.getProperty("browser");
		
		System.out.println("browser-> " + browser);
		System.out.println("url -> " + ConfigsReader.getProperty("url"));
		System.out.println("username -> " + ConfigsReader.getProperty("username"));
		System.out.println("password -> " + ConfigsReader.getProperty("password"));
		
		
	}
}
