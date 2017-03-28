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
public class FieldUserServiceImpl implements FieldUserService {

	@Autowired
	FieldUserDao fieldUserDao;
	
	@Autowired
	UserAssetDao userAssetDao;
	
	@Autowired
	AssetDao assetDao;
	
	@Override
	public Map<String, Object> getFieldUserDetailsByExternalId(String SCHEMA_NAME, String externalId) throws Exception {
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		boolean status = false;
		if(DeviceManagerUtil.IsNotEmpty(SCHEMA_NAME) && DeviceManagerUtil.IsNotEmpty(externalId)) {
			try {
				FieldUser fieldUser = fieldUserDao.getFieldUserByExternalId(SCHEMA_NAME, externalId);
				if(fieldUser != null && DeviceManagerUtil.IsNotEmpty(fieldUser.getExternalId())) {
					rtnObject.put("fieldUser", fieldUser);
					
					List<UserAsset> userAssetList = userAssetDao.getUserAssetByAssetId(SCHEMA_NAME, fieldUser.getId());
					if(userAssetList!=null && !userAssetList.isEmpty()) {
						rtnObject.put("userAssetList", userAssetList);
						List<Integer> assetIds = new ArrayList<Integer>();
						for(UserAsset userAsset : userAssetList) {
							assetIds.add(userAsset.getAssetId());
						}
						if(!assetIds.isEmpty()) {
							List<Asset> assetList = assetDao.getAssetByIds(SCHEMA_NAME, assetIds);
							if(assetList!=null) {
								rtnObject.put("assetList", assetList);
							}
							status = true;
						}
					}
				} 
			} catch (Exception e) {
				throw e;
			}
		}
		rtnObject.put("status", status);
		return rtnObject;
	}
	
}
