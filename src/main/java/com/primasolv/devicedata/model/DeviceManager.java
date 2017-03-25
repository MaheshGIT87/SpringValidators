/**
 * 
 */
package com.primasolv.devicedata.model;

import java.io.Serializable;

/**
 * @author kiran
 *
 */
public class DeviceManager implements Serializable {
	
	private static final long serialVersionUID = -5601620497654974451L;
	
	private String dmId;
	private String region;
	private String dmEnvType;
	private String dmName;
	private String appEnv;
	private String dmUrl;
	private String dbSchema;
	
	/**
	 * @return the dmId
	 */
	public String getDmId() {
		return dmId;
	}
	/**
	 * @param dmId the dmId to set
	 */
	public void setDmId(String dmId) {
		this.dmId = dmId;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the dmEnvType
	 */
	public String getDmEnvType() {
		return dmEnvType;
	}
	/**
	 * @param dmEnvType the dmEnvType to set
	 */
	public void setDmEnvType(String dmEnvType) {
		this.dmEnvType = dmEnvType;
	}
	/**
	 * @return the dmName
	 */
	public String getDmName() {
		return dmName;
	}
	/**
	 * @param dmName the dmName to set
	 */
	public void setDmName(String dmName) {
		this.dmName = dmName;
	}
	/**
	 * @return the appEnv
	 */
	public String getAppEnv() {
		return appEnv;
	}
	/**
	 * @param appEnv the appEnv to set
	 */
	public void setAppEnv(String appEnv) {
		this.appEnv = appEnv;
	}
	/**
	 * @return the dmUrl
	 */
	public String getDmUrl() {
		return dmUrl;
	}
	/**
	 * @param dmUrl the dmUrl to set
	 */
	public void setDmUrl(String dmUrl) {
		this.dmUrl = dmUrl;
	}
	/**
	 * @return the dbSchema
	 */
	public String getDbSchema() {
		return dbSchema;
	}
	/**
	 * @param dbSchema the dbSchema to set
	 */
	public void setDbSchema(String dbSchema) {
		this.dbSchema = dbSchema;
	}
}

