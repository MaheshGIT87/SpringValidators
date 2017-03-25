/**
 * 
 */
package com.primasolv.devicedata.dao;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.Asset;

/**
 * @author kiran
 *
 */
@Repository
public interface AssetDao {
	
	public Asset getAssetBySerialNumber(String schemaName, String serialNumber);
	
}
