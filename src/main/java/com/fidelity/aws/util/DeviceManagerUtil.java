/**
 * 
 */
package com.fidelity.aws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;

/**
 * @author kiran
 *
 */
public class DeviceManagerUtil {
	
	static  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	static  SimpleDateFormat sdfTimeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

	/**
	 * Checks the empty value
	 * @param input
	 * @return
	 */
    public static boolean IsEmpty(String input) {
        boolean decision = false;
        if (input == null || input.equals("") || "null".equals(input)) decision = true;
        return decision;
    }

    /**
     * Checks the empty value
     * @param input
     * @return
     */
    public static boolean IsNotEmpty(String input) {
        return !IsEmpty(input);
    }
	
    /**
     * Get current date
     * @return
     */
	public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(Calendar.getInstance().getTime());
    }
	
	/**
	 * Get Comma Seperated Value
	 * @param ids
	 * @return
	 */
	public static String generateCommaSeperated(List<Integer> ids) {
		StringBuilder result = new StringBuilder();
	    for(Integer id : ids) {
	        result.append(id.intValue());
	        result.append(",");
	    }
	    return result.length() > 0 ? result.substring(0, result.length() - 1): "";
	}
	
	
	public static Map<String, Object> baseResObject() {
		Map<String, Object> rtnObj = new HashMap<String, Object>();
		rtnObj.put("status", false);
		rtnObj.put("errMsg", "");
		rtnObj.put("devErrMsg", "");
		rtnObj.put("stackTrace", "");
		return rtnObj;
	}
	
	/**
	 * Convert value to String
	 * @param beanToParse
	 * @param value
	 * @return
	 */
	public static String convertBeanValueToString(DynaBean beanToParse, String value) {
        String result = null;
        if ((beanToParse.get(value) != null) && IsNotEmpty(beanToParse.get(value).toString())) {
            result = beanToParse.get(value).toString();
        } else {
            result = "null";
        }
        return result;
    }

	/**
	 * Convert Bean value to Integer
	 * @param beanToParse
	 * @param value
	 * @return
	 */
    public static int convertBeanValueToInt(DynaBean beanToParse, String value) {
        int result = 0;
        if (beanToParse.get(value) != null) {
            result = Integer.parseInt(convertBeanValueToString(beanToParse, value));
        }
        return result;
    }
    
    /**
     * Convert Bean value to Boolean
     * @param beanToParse
     * @param value
     * @return
     */
    public static boolean convertBeanValueToBoolean(DynaBean beanToParse, String value) {
        boolean result = false;
        if (beanToParse.get(value) != null) {
            result = Boolean.parseBoolean(convertBeanValueToString(beanToParse, value));
        }
        return result;
    }    

    /**
     * Convert Bean value to Date
     * @param beanToParse
     * @param value
     * @return
     */
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
    
    /**
     * Convert bean value to TimeStamp
     * @param beanToParse
     * @param value
     * @return
     */
    public java.util.Date convertBeanValueToTimeStamp(DynaBean beanToParse, String value) {
        java.util.Date result = null;
        if (beanToParse.get(value) != null) {
            try {
                result = sdfTimeStamp.parse(beanToParse.get(value).toString());
            } catch (ParseException pe) {
            }
        }
        return result;
    }
	
}
