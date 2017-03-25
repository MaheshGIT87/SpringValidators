/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primasolv.devicedata.dao.DeviceManagerDao;
import com.primasolv.devicedata.model.DeviceManager;

/**
 * @author kiran
 *
 */
@Service
public class DeviceManagerServiceImpl implements DeviceManagerService {

	@Autowired
	DeviceManagerDao deviceManagerDao;
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.service.DeviceManagerService#getDeviceManagerList()
	 */
	@Override
	public List<DeviceManager> getDeviceManagerList() {
		return deviceManagerDao.getDeviceManagerNames();
	}

}
