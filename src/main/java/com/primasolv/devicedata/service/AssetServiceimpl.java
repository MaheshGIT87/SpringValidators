/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primasolv.devicedata.dao.AssetDao;
import com.primasolv.devicedata.dao.FieldUserDao;
import com.primasolv.devicedata.dao.UserAssetDao;
import com.primasolv.devicedata.model.Asset;
import com.primasolv.devicedata.model.FieldUser;
import com.primasolv.devicedata.model.UserAsset;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Service
public class AssetServiceimpl implements AssetService {

	@Autowired
	AssetDao assetDao;
	
	@Autowired
	UserAssetDao userAssetDao;
	
	@Autowired
	FieldUserDao fieldUserDao;
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.service.AssetService#getAssetDetailsBySerialNumber(java.lang.String)
	 */
	@Override
	public Map<String, Object> getAssetDetailsBySerialNumber(String SCHEMA_NAME, String serialNumber) {
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		if(DeviceManagerUtil.IsNotEmpty(SCHEMA_NAME) && DeviceManagerUtil.IsNotEmpty(serialNumber)) {
			
			Asset asset = assetDao.getAssetBySerialNumber(SCHEMA_NAME, serialNumber);
			rtnObject.put("asset", asset);
			
			if(asset != null) {
				List<UserAsset> userAssetList = userAssetDao.getUserAssetByAssetId(SCHEMA_NAME, asset.getId());
				
				if(userAssetList!=null && !userAssetList.isEmpty()) {
					rtnObject.put("userAssetList", userAssetList);
					
					List<Integer> fieldUserIds = new ArrayList<Integer>();
					for(UserAsset userAsset : userAssetList) {
						fieldUserIds.add(userAsset.getFieldUserId());
					}
					
					List<FieldUser> fieldUserList = fieldUserDao.getFieldUsersByIds(SCHEMA_NAME, fieldUserIds);
					if(fieldUserList!=null) {
						rtnObject.put("fieldUserList", fieldUserList);
					}
				}
			}
		}
		
		return rtnObject;
	}

}
