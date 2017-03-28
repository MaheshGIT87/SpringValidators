/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primasolv.devicedata.dao.DealerDao;
import com.primasolv.devicedata.model.Dealer;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	DealerDao dealerDao;
	
	@Override
	public Map<String, Object> getDealerDetailsById(String SCHEMA_NAME, int dealerId) throws Exception {
		
		Map<String, Object> rtnObject = new HashMap<String, Object>();
		if(DeviceManagerUtil.IsNotEmpty(SCHEMA_NAME)) {
			try {
				Dealer dealer = dealerDao.getDealerById(SCHEMA_NAME, dealerId);
				if(dealer != null) {
					rtnObject.put("dealer", dealer);
				}
			} catch (Exception e) {
				throw e;
			}
		}
		return rtnObject;
	}

}
