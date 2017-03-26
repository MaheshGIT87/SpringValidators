/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.primasolv.devicedata.model.Asset;

/**
 * @author kiran
 *
 */
@Service
public interface AssetService {
	
	public Map<String, Object> getAssetDetailsBySerialNumber(String SCHEMA_NAME, String serialNumber);
	
}
