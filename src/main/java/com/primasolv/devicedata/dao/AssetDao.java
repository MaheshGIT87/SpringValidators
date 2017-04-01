/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.Asset;

/**
 * @author kiran
 *
 */
@Repository
public interface AssetDao {
	
	public Asset getAssetBySerialNumber(String schemaName, String serialNumber) throws Exception;
	
	public List<Asset> getAssetByIds(String SCHEMA_NAME, List<Integer> assetIds) throws Exception;
	
	public List<String> getAllAssetSerialNos(String SCHEMA_NAME) throws Exception;
	
}
