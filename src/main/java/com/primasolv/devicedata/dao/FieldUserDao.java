/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.FieldUser;

/**
 * @author kiran
 *
 */
@Repository
public interface FieldUserDao {
	
	public FieldUser getFieldUserById(String SCHEMA_NAME, int fieldUserId) throws Exception;
	
	public List<FieldUser> getFieldUsersByIds(String SCHEMA_NAME, List<Integer> fieldUserIds) throws Exception;
	
	public FieldUser getFieldUserByExternalId(String SCHEMA_NAME, String externalId) throws Exception;
}
