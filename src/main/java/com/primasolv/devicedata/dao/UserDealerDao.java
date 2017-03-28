/**
 * 
 */
package com.primasolv.devicedata.dao;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.UserDealer;

/**
 * @author kiran
 *
 */
@Repository
public interface UserDealerDao {
	public UserDealer getUserDealerByDealerId(String SCHEMA_NAME, int dealerId) throws Exception;
	public UserDealer getUserDealerByFieldUserId(String SCHEMA_NAME, int fieldUserId) throws Exception;
}
