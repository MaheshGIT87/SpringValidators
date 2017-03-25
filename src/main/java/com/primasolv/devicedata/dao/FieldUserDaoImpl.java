/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.FieldUser;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class FieldUserDaoImpl implements FieldUserDao {
	
	private  static final String SQL_USER_ASSET_BY_FIELD_USER_ID = "select * from field_user where id=%s";
	private  static final String SQL_USER_ASSET_BY_FIELD_USER_IDS = "select * from field_user where id in (%s)";

	

	@Override
	public FieldUser getFieldUserById(String SCHEMA_NAME, int fieldUserId) {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		List<FieldUser> fieldUserList = new ArrayList<FieldUser>();
		try {
			String sql = String.format(SQL_USER_ASSET_BY_FIELD_USER_ID, fieldUserId);
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            fieldUserList.add(convertBeanToFieldUser(myBean));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldUserList.get(0);
	}

	@Override
	public List<FieldUser> getFieldUsersByIds(String SCHEMA_NAME, List<Integer> fieldUserIds) {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		List<FieldUser> fieldUserList = new ArrayList<FieldUser>();
		try {
			//TODO: Ids
			String sql = String.format(SQL_USER_ASSET_BY_FIELD_USER_IDS, 1);
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            fieldUserList.add(convertBeanToFieldUser(myBean));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldUserList;
	}
	
	/**
	 * 
	 * @param myBean
	 * @return
	 * 
	 */
	private FieldUser convertBeanToFieldUser(DynaBean myBean) {
		FieldUser user = new FieldUser();
		if(myBean != null) {
			user.setId(DeviceManagerUtil.convertBeanValueToInt(myBean, "id"));
			user.setExternalId(DeviceManagerUtil.convertBeanValueToString(myBean, "external_id"));
			user.setFirstName(DeviceManagerUtil.convertBeanValueToString(myBean, "first_name"));
			user.setLastName(DeviceManagerUtil.convertBeanValueToString(myBean, "last_name"));
			user.setPortalId(DeviceManagerUtil.convertBeanValueToInt(myBean, "portal_id"));
			user.setSource(DeviceManagerUtil.convertBeanValueToString(myBean, "source"));
			user.setOwner(DeviceManagerUtil.convertBeanValueToString(myBean, "owner"));
		}
		return user;
	}
	

}
