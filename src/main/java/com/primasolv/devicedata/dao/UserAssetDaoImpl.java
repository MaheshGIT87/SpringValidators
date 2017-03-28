/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.UserAsset;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class UserAssetDaoImpl implements UserAssetDao {
	
	private  static final String SQL_USER_ASSET_BY_ASSET_ID = "select * from user_asset_mapping where asset_id=%s";

	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.dao.UserDao#getUserAssetByAssetId(java.lang.String, int)
	 */
	@Override
	public List<UserAsset> getUserAssetByAssetId(String SCHEMA_NAME, int assetId) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		List<UserAsset> userAssetList = new ArrayList<UserAsset>();
		try {
			String sql = String.format(SQL_USER_ASSET_BY_ASSET_ID, assetId);
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            userAssetList.add(convertBeanToUserAsset(myBean));
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userAssetList;
	}
	
	
	/**
	 * 
	 * @param myBean
	 * @return
	 * 
	 */
	private UserAsset convertBeanToUserAsset(DynaBean myBean) {
		UserAsset userAsset = new UserAsset();
		if(myBean != null) {
			userAsset.setId(DeviceManagerUtil.convertBeanValueToInt(myBean, "id"));
			userAsset.setSource(DeviceManagerUtil.convertBeanValueToString(myBean, "source"));
			userAsset.setAssetId(DeviceManagerUtil.convertBeanValueToInt(myBean, "asset_id"));
			userAsset.setFieldUserId(DeviceManagerUtil.convertBeanValueToInt(myBean, "field_user_id"));
			userAsset.setOwner(DeviceManagerUtil.convertBeanValueToString(myBean, "owner"));
		}
		return userAsset;
	}

}
