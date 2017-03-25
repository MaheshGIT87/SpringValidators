/**
 * 
 */
package com.primasolv.devicedata.service;

import org.springframework.stereotype.Service;

import com.primasolv.devicedata.model.Asset;

/**
 * @author kiran
 *
 */
@Service
public interface AssetService {
	
	public Asset getAssetDetailsBySerialNumber(String SCHEMA_NAME, String serialNumber);
	
}
