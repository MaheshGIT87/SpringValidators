/**
 * 
 */
package com.primasolv.devicedata.dao;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.Dealer;


/**
 * @author kiran
 *
 */
@Repository
public interface DealerDao {
	public Dealer getDealerById(String schemaName, int dealerId) throws Exception;
}
