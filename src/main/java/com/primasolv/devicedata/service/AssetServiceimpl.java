/**
 * 
 */
package com.primasolv.devicedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primasolv.devicedata.dao.AssetDao;
import com.primasolv.devicedata.model.Asset;

/**
 * @author kiran
 *
 */
@Service
public class AssetServiceimpl implements AssetService {

	@Autowired
	AssetDao assetDao;
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.service.AssetService#getAssetDetailsBySerialNumber(java.lang.String)
	 */
	@Override
	public Asset getAssetDetailsBySerialNumber(String SCHEMA_NAME, String serialNumber) {
		return assetDao.getAssetBySerialNumber(SCHEMA_NAME, serialNumber);
	}

}
