/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.primasolv.devicedata.model.DeviceManager;

/**
 * @author kiran
 *
 */
@Service
public interface DeviceManagerService {
	
	public List<DeviceManager> getDeviceManagerList();
}
