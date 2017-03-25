/**
 * 
 */
package com.primasolv.devicedata.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author kiran
 *
 */
@RestController
public class DeviceManagerController {
	
	@GetMapping(value = "/selectEnv/{dmName}/{dmDisplayName}")
	public Map<String, Object> selectEnv(@PathVariable("dmName") String dmName,@PathVariable("dmDisplayName") String dmDisplayName,  HttpSession session) {
		System.out.println("Selected dmName::" + dmName + "--dmDisplayName:"+dmDisplayName);
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		if(dmName!=null) {
			session.setAttribute("selectedDmName", dmName);
			session.setAttribute("selectedDmDisplayName", dmDisplayName);
			rtnObject.put("selectedDmName", dmName);
			rtnObject.put("selectedDmDisplayName", dmDisplayName);
		}
		return rtnObject;
	}
}
