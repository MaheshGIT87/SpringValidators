/*
 * Created on Oct 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.primasolv.devicedata.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	public String getPropertyValue(String propertyKey){
		Properties properties = new Properties();
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("appDeviceManagerConfig.properties");
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String outValue = properties.getProperty(propertyKey);
		return outValue;		
	}
	
	public static void main(String[] args){
			System.out.println(new PropertiesReader().getPropertyValue("dm_latamtest.database.url"));
	}

}
