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
public interface FieldUserService {

	public Map<String, Object> getFieldUserDetailsByExternalId(String SCHEMA_NAME, String externalId) throws Exception;
	
}
