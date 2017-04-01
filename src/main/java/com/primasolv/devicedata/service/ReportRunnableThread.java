/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.primasolv.devicedata.dao.AssetDao;
import com.primasolv.devicedata.dao.AssetDaoImpl;

/**
 * @author kiran
 *
 */
public class ReportRunnableThread implements Runnable {
	public static int myCount = 0;
	public static boolean isReportGenerated = false;
	
	public List<String> schemas =  Arrays.asList("dm_emeapilot", "dm_apacpilot", "dm_latampilot", "dm_naftapilot");
	
	Map<String,ArrayList<String>> multiMap = new HashMap<String,ArrayList<String>>();
	
    public ReportRunnableThread() {
    }
    
    public void run() {
    	for(String schema: schemas) {
    		AssetDao assetDao = new AssetDaoImpl();
    		try {
				List<String> list = assetDao.getAllAssetSerialNos(schema);
				for(String serialNo: list) {
					if (multiMap.containsKey(serialNo)) {
						multiMap.get(serialNo).add(schema);
			        } else {
			        	ArrayList<String> l = new ArrayList<String>();
			        	l.add(schema);
			        	multiMap.put(serialNo, l);
			        }
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	System.out.println(multiMap);
    }
    
    public static void main(String args[]){  
    	ReportRunnableThread m1=new ReportRunnableThread();  
    	Thread t1 =new Thread(m1);  
    	t1.start(); 
    }  
}
