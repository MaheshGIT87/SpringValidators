/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.DeviceManager;

/**
 * @author kiran
 *
 */
@Repository
public interface DeviceManagerDao {
	
	public void getDeviceRegions();
	
	public void getEnvTypes();
	
	public List<DeviceManager> getDeviceManagerNames() throws Exception;
}
