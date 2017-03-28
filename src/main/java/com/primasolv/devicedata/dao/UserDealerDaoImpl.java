/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.UserDealer;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class UserDealerDaoImpl implements UserDealerDao {

	private  static final String SQL_USER_DEALER_BY_DEALER_ID = "select * from user_asset_mapping where dealer_id=%s";
	private  static final String SQL_USER_DEALER_BY_FIELD_USER_ID = "select * from user_asset_mapping where field_user_id=%s";
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.dao.UserDealerDao#getUserDealerByDealerId(java.lang.String, int)
	 */
	@Override
	public UserDealer getUserDealerByDealerId(String SCHEMA_NAME, int dealerId) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		UserDealer userDealer = null;
		try {
			List<UserDealer> userDealerList = new ArrayList<UserDealer>();
			String sql = String.format(SQL_USER_DEALER_BY_DEALER_ID, dealerId);
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            userDealerList.add(convertBeanToUserDealer(myBean));
	        }
	        if(!userDealerList.isEmpty()) {
	        	userDealer = userDealerList.get(0);
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userDealer;
	}

	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.dao.UserDealerDao#getUserDealerByFieldUserId(java.lang.String, int)
	 */
	@Override
	public UserDealer getUserDealerByFieldUserId(String SCHEMA_NAME, int fieldUserId) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		UserDealer userDealer = null;
		try {
			List<UserDealer> userDealerList = new ArrayList<UserDealer>();
			String sql = String.format(SQL_USER_DEALER_BY_FIELD_USER_ID, fieldUserId);
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            userDealerList.add(convertBeanToUserDealer(myBean));
	        }
	        if(!userDealerList.isEmpty()) {
	        	userDealer = userDealerList.get(0);
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return userDealer;
	}
	
	/**
	 * 
	 * @param myBean
	 * @return
	 * 
	 */
	private UserDealer convertBeanToUserDealer(DynaBean myBean) {
		UserDealer userDealer = new UserDealer();
		if(myBean != null) {
			userDealer.setId(DeviceManagerUtil.convertBeanValueToInt(myBean, "id"));
			userDealer.setSource(DeviceManagerUtil.convertBeanValueToString(myBean, "source"));
			userDealer.setDealerId(DeviceManagerUtil.convertBeanValueToInt(myBean, "dealer_id"));
			userDealer.setFieldUserId(DeviceManagerUtil.convertBeanValueToInt(myBean, "field_user_id"));
			userDealer.setOwner(DeviceManagerUtil.convertBeanValueToString(myBean, "owner"));
		}
		return userDealer;
	}

}
