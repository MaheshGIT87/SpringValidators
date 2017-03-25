/**
 * 
 */
package com.primasolv.devicedata.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author kiran
 *
 */
public class Dealer implements Serializable {
	
	private static final long serialVersionUID = 6711776304769935421L;
	
	private int id;
	private String dealerCode;
	private int portalId;
	private String source;
	private int podLogLevel;
	private String podFlashLogLevel;
	private int podLogLimit;
	private boolean podhibernate;
	private boolean podRandomize;
	private String name;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String subRegion;
	private String zip;
	private String businessCenter;
	private String taxId;
	private String zone;
	private int companyId;
	private int countryId;
	private Timestamp createDate;
	private int regionId;
	private String dbAdminComment;
	private String marketCode;
	private String email;
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
	 * @return the dealerCode
	 */
	public String getDealerCode() {
		return dealerCode;
	}
	/**
	 * @param dealerCode the dealerCode to set
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
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
	 * @return the podhibernate
	 */
	public boolean isPodhibernate() {
		return podhibernate;
	}
	/**
	 * @param podhibernate the podhibernate to set
	 */
	public void setPodhibernate(boolean podhibernate) {
		this.podhibernate = podhibernate;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}
	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the subRegion
	 */
	public String getSubRegion() {
		return subRegion;
	}
	/**
	 * @param subRegion the subRegion to set
	 */
	public void setSubRegion(String subRegion) {
		this.subRegion = subRegion;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the businessCenter
	 */
	public String getBusinessCenter() {
		return businessCenter;
	}
	/**
	 * @param businessCenter the businessCenter to set
	 */
	public void setBusinessCenter(String businessCenter) {
		this.businessCenter = businessCenter;
	}
	/**
	 * @return the taxId
	 */
	public String getTaxId() {
		return taxId;
	}
	/**
	 * @param taxId the taxId to set
	 */
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}
	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}
	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the regionId
	 */
	public int getRegionId() {
		return regionId;
	}
	/**
	 * @param regionId the regionId to set
	 */
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	/**
	 * @return the dbAdminComment
	 */
	public String getDbAdminComment() {
		return dbAdminComment;
	}
	/**
	 * @param dbAdminComment the dbAdminComment to set
	 */
	public void setDbAdminComment(String dbAdminComment) {
		this.dbAdminComment = dbAdminComment;
	}
	/**
	 * @return the marketCode
	 */
	public String getMarketCode() {
		return marketCode;
	}
	/**
	 * @param marketCode the marketCode to set
	 */
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
