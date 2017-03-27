package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.DeviceManager;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * 
 * @author kiran
 *
 */
@Repository
public class DeviceManagerDaoImpl implements DeviceManagerDao {
	
	
	private static final String SQL_DEVICE_MN = "select * from wt2_dm where db_schema IS NOT NULL;";
	private static final String SQL_TEST_SCHEMA = "dm_latamtest";

	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceManager> getDeviceManagerNames() {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SQL_TEST_SCHEMA);
		List<DeviceManager> deviceManageList = new ArrayList<DeviceManager>();
		Collection<DynaBean> result;
		try {
			result = jcm.execute(SQL_DEVICE_MN);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            deviceManageList.add(convertBeanToDeviceManager(myBean));
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deviceManageList;
	}
	
	@Override
	public void getDeviceRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEnvTypes() {
		// TODO Auto-generated method stub

	}
    
    /**
     * 
     * @param myBean
     * @return
     */
    private DeviceManager convertBeanToDeviceManager(DynaBean myBean) {
    	DeviceManager deviceManager = new DeviceManager();
    	if(myBean != null) {
	    	deviceManager.setDmId(DeviceManagerUtil.convertBeanValueToString(myBean, "dm_id"));
	    	deviceManager.setRegion(DeviceManagerUtil.convertBeanValueToString(myBean, "region"));
	    	deviceManager.setDmEnvType(DeviceManagerUtil.convertBeanValueToString(myBean, "dm_env_type"));
	    	deviceManager.setDmName(DeviceManagerUtil.convertBeanValueToString(myBean, "dm_name"));
	    	deviceManager.setAppEnv(DeviceManagerUtil.convertBeanValueToString(myBean, "app_env"));
	    	deviceManager.setDmUrl(DeviceManagerUtil.convertBeanValueToString(myBean, "dm_url"));
	    	deviceManager.setDbSchema(DeviceManagerUtil.convertBeanValueToString(myBean, "db_schema"));
    	}
        return deviceManager;
    }
    
}
