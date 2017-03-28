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
import com.primasolv.devicedata.dao.DealerDao;
import com.primasolv.devicedata.dao.FieldUserDao;
import com.primasolv.devicedata.dao.UserAssetDao;
import com.primasolv.devicedata.model.Asset;
import com.primasolv.devicedata.model.Dealer;
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
	
	@Autowired
	DealerDao dealerDao;
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.service.AssetService#getAssetDetailsBySerialNumber(java.lang.String)
	 */
	@Override
	public Map<String, Object> getAssetDetailsBySerialNumber(String SCHEMA_NAME, String serialNumber) throws Exception{
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		boolean status = false;
		if(DeviceManagerUtil.IsNotEmpty(SCHEMA_NAME) && DeviceManagerUtil.IsNotEmpty(serialNumber)) {
			
			try {
				Asset asset = assetDao.getAssetBySerialNumber(SCHEMA_NAME, serialNumber);
				if(asset != null) {
					rtnObject.put("asset", asset);
					
					if(asset.getDealerId() != 0) {
						Dealer dealer = dealerDao.getDealerById(SCHEMA_NAME, asset.getDealerId());
						rtnObject.put("dealer", dealer);
					}
					List<UserAsset> userAssetList = userAssetDao.getUserAssetByAssetId(SCHEMA_NAME, asset.getId());
					if(userAssetList!=null && !userAssetList.isEmpty()) {
						rtnObject.put("userAssetList", userAssetList);
						List<Integer> fieldUserIds = new ArrayList<Integer>();
						for(UserAsset userAsset : userAssetList) {
							fieldUserIds.add(userAsset.getFieldUserId());
						}
						if(!fieldUserIds.isEmpty()) {
							List<FieldUser> fieldUserList = fieldUserDao.getFieldUsersByIds(SCHEMA_NAME, fieldUserIds);
							if(fieldUserList!=null) {
								rtnObject.put("fieldUserList", fieldUserList);
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
