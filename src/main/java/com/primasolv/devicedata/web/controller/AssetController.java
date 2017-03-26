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

import com.primasolv.devicedata.model.Asset;
import com.primasolv.devicedata.service.AssetService;

/**
 * @author kiran
 *
 */
@RestController
public class AssetController {

	@Autowired
	AssetService assetService;
	
	@GetMapping(value = "/asset/{serialNo}")
	public Map<String, Object> getAssetBySerialNo(@PathVariable("serialNo") String serialNo,  HttpSession session) {
		System.out.println("Selected serialNo::" + serialNo);
		Map<String, Object> rtnObject = null;
		if(serialNo!=null) {
			String schema_name = (String)session.getAttribute("selectedDmName");
			rtnObject = assetService.getAssetDetailsBySerialNumber(schema_name, serialNo);
			rtnObject.put("status", "success");
		}
		return rtnObject;
	}
	
}
