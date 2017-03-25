/**
 * 
 */
package com.primasolv.devicedata.model;

import java.io.Serializable;

/**
 * @author kiran
 */
public class Asset implements Serializable {

	private static final long serialVersionUID = 9059544065865661489L;
	
	private int id;
	private String appVersion;
	private int dealerId;
	private String osVersion;
	private int portalId;
	private String serialNumber;
	private String source;
	private int applicationEnvironmentId;
	private String deviceMgrUrl;
	private String socChipId;
	private String ioCardChipId;
	private int podLogLevel;
	private String podFlashLogLevel;
	private int podLogLimit;
	private boolean podHibernate;
	private boolean podRandomize;
	private String type;
	private String integrity;
	private String owner;
	private boolean podSshdEnable;
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
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}
	/**
	 * @param appVersion the appVersion to set
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
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
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}
	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	/**
	 * @return the portalId
	 */
	public int getPortalId() {
		return portalId;
	}
	/**
	 * @param portalId the portalId to set
	 */
	public void setPortalId(int portalId) {
		this.portalId = portalId;
	}
	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	 * @return the applicationEnvironmentId
	 */
	public int getApplicationEnvironmentId() {
		return applicationEnvironmentId;
	}
	/**
	 * @param applicationEnvironmentId the applicationEnvironmentId to set
	 */
	public void setApplicationEnvironmentId(int applicationEnvironmentId) {
		this.applicationEnvironmentId = applicationEnvironmentId;
	}
	/**
	 * @return the deviceMgrUrl
	 */
	public String getDeviceMgrUrl() {
		return deviceMgrUrl;
	}
	/**
	 * @param deviceMgrUrl the deviceMgrUrl to set
	 */
	public void setDeviceMgrUrl(String deviceMgrUrl) {
		this.deviceMgrUrl = deviceMgrUrl;
	}
	/**
	 * @return the socChipId
	 */
	public String getSocChipId() {
		return socChipId;
	}
	/**
	 * @param socChipId the socChipId to set
	 */
	public void setSocChipId(String socChipId) {
		this.socChipId = socChipId;
	}
	/**
	 * @return the ioCardChipId
	 */
	public String getIoCardChipId() {
		return ioCardChipId;
	}
	/**
	 * @param ioCardChipId the ioCardChipId to set
	 */
	public void setIoCardChipId(String ioCardChipId) {
		this.ioCardChipId = ioCardChipId;
	}
	/**
	 * @return the podLogLevel
	 */
	public int getPodLogLevel() {
		return podLogLevel;
	}
	/**
	 * @param podLogLevel the podLogLevel to set
	 */
	public void setPodLogLevel(int podLogLevel) {
		this.podLogLevel = podLogLevel;
	}
	/**
	 * @return the podFlashLogLevel
	 */
	public String getPodFlashLogLevel() {
		return podFlashLogLevel;
	}
	/**
	 * @param podFlashLogLevel the podFlashLogLevel to set
	 */
	public void setPodFlashLogLevel(String podFlashLogLevel) {
		this.podFlashLogLevel = podFlashLogLevel;
	}
	/**
	 * @return the podLogLimit
	 */
	public int getPodLogLimit() {
		return podLogLimit;
	}
	/**
	 * @param podLogLimit the podLogLimit to set
	 */
	public void setPodLogLimit(int podLogLimit) {
		this.podLogLimit = podLogLimit;
	}
	/**
	 * @return the podHibernate
	 */
	public boolean isPodHibernate() {
		return podHibernate;
	}
	/**
	 * @param podHibernate the podHibernate to set
	 */
	public void setPodHibernate(boolean podHibernate) {
		this.podHibernate = podHibernate;
	}
	/**
	 * @return the podRandomize
	 */
	public boolean isPodRandomize() {
		return podRandomize;
	}
	/**
	 * @param podRandomize the podRandomize to set
	 */
	public void setPodRandomize(boolean podRandomize) {
		this.podRandomize = podRandomize;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the integrity
	 */
	public String getIntegrity() {
		return integrity;
	}
	/**
	 * @param integrity the integrity to set
	 */
	public void setIntegrity(String integrity) {
		this.integrity = integrity;
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
	/**
	 * @return the podSshdEnable
	 */
	public boolean isPodSshdEnable() {
		return podSshdEnable;
	}
	/**
	 * @param podSshdEnable the podSshdEnable to set
	 */
	public void setPodSshdEnable(boolean podSshdEnable) {
		this.podSshdEnable = podSshdEnable;
	}
}
