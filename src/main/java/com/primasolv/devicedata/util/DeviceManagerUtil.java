/**
 * 
 */
package com.primasolv.devicedata.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.beanutils.DynaBean;

/**
 * @author kiran
 *
 */
public class DeviceManagerUtil {
	
	static  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	static  SimpleDateFormat sdfTimeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

    public static boolean IsEmpty(String input) {
        boolean decision = false;
        if (input == null || input.equals("") || "null".equals(input)) decision = true;
        return decision;
    }

    public static boolean IsNotEmpty(String input) {
        return !IsEmpty(input);
    }
	
	public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
	
	public static String convertBeanValueToString(DynaBean beanToParse, String value) {
        String result = null;
        if ((beanToParse.get(value) != null) && IsNotEmpty(beanToParse.get(value).toString())) {
            result = beanToParse.get(value).toString();
        } else {
            result = "null";
        }
        return result;
    }

    public static int convertBeanValueToInt(DynaBean beanToParse, String value) {
        int result = 0;
        if (beanToParse.get(value) != null) {
            result = Integer.parseInt(convertBeanValueToString(beanToParse, value));
        }
        return result;
    }

    public static java.util.Date convertBeanValueToDate(DynaBean beanToParse, String value) {
        java.util.Date result = null;
        if (beanToParse.get(value) != null) {
            try {
                result = sdf.parse(beanToParse.get(value).toString());
            } catch (ParseException pe) {
            }
        }
        return result;
    }
	
}
