/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.UserAsset;

/**
 * @author kiran
 *
 */
@Repository
public interface UserAssetDao {
	public List<UserAsset> getUserAssetByAssetId(String SCHEMA_NAME, int assetId);
}
