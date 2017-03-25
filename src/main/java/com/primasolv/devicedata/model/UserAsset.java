/**
 * 
 */
package com.primasolv.devicedata.model;

import java.io.Serializable;

/**
 * @author kiran
 *id	int(11)
source	varchar(30)
asset_id	int(11)
field_user_id	int(11)
owner	varchar(10)
 */
public class UserAsset implements Serializable {
	
	private static final long serialVersionUID = 7972747479019784837L;
	
	private int id;
	private String source;
	private int assetId;
	private int fieldUserId;
	private String owner;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the assetId
	 */
	public int getAssetId() {
		return assetId;
	}
	/**
	 * @param assetId the assetId to set
	 */
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	/**
	 * @return the fieldUserId
	 */
	public int getFieldUserId() {
		return fieldUserId;
	}
	/**
	 * @param fieldUserId the fieldUserId to set
	 */
	public void setFieldUserId(int fieldUserId) {
		this.fieldUserId = fieldUserId;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
