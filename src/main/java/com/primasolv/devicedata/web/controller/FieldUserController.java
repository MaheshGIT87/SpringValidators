/**
 * 
 */
package com.primasolv.devicedata.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.primasolv.devicedata.service.FieldUserService;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@RestController
public class FieldUserController {

	@Autowired
	FieldUserService fieldUserService;
	
	@GetMapping(value = "/fieldUser/{externalId}")
	public Map<String, Object> getAssetBySerialNo(@PathVariable("externalId") String externalId,  HttpSession session) {
		System.out.println("Selected External Id::" + externalId);
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		try {
			if(DeviceManagerUtil.IsNotEmpty(externalId)) {
				String schema_name = (String)session.getAttribute("selectedDmName");
				rtnObject = fieldUserService.getFieldUserDetailsByExternalId(schema_name, externalId);
				if(!(boolean)rtnObject.get("status")) {
					rtnObject.put("errMsg", "Unable to fetch the details");
				}
			}
		} catch (Exception e) {
			rtnObject.put("stackTrace", e.getMessage());
			rtnObject.put("status", false);
			rtnObject.put("errMsg", "An Exception has been occurred");
			e.printStackTrace();
		}
		return rtnObject;
	}
}
