/**
 * 
 */
package com.primasolv.devicedata.model;

import java.io.Serializable;

/**
 * @author kiran
 *
 */
public class UserDealer implements Serializable {

	private static final long serialVersionUID = -4497636259804532784L;
	
	private int id;
	private String source;
	private int dealerId;
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
	 * @return the dealerId
	 */
	public int getDealerId() {
		return dealerId;
	}
	/**
	 * @param dealerId the dealerId to set
	 */
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
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
