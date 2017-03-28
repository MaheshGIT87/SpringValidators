/**
 * 
 */
package com.primasolv.devicedata.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author kiran
 *
 */
@Service
public interface DealerService {
	
	public Map<String, Object> getDealerDetailsById(String SCHEMA_NAME, int dealerId) throws Exception;
	
}
