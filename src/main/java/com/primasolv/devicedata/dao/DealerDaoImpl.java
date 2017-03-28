/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.Dealer;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Repository
public class DealerDaoImpl implements DealerDao {
	
	private  static final String SQL_DEALER_BY_ID = "select * from dealer where id='%s'";

	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.dao.DealerDao#getDealerById(java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Dealer getDealerById(String SCHEMA_NAME, int dealerId) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		Dealer dealer = new Dealer();
		try {
			String sql = String.format(SQL_DEALER_BY_ID, dealerId);
			Collection<DynaBean> result = jcm.execute(sql);
			List<Dealer> dealerList = new ArrayList<Dealer>();
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            dealerList.add(convertBeanToDealer(myBean));
	        }
	        if(!dealerList.isEmpty()) {
	        	dealer = dealerList.get(0);
	        }
		} catch (Exception e) {
			throw e;
		}
		return dealer;
	}
	
	/**
	 * 
	 * @param myBean
	 * @return
	 * 
	 */
	private Dealer convertBeanToDealer(DynaBean myBean) {
		Dealer dealer = new Dealer();
    	if(myBean != null) {
    		dealer.setId(DeviceManagerUtil.convertBeanValueToInt(myBean, "id"));
    		dealer.setDealerCode(DeviceManagerUtil.convertBeanValueToString(myBean, "dealer_code"));
    		dealer.setPortalId(DeviceManagerUtil.convertBeanValueToInt(myBean, "portal_id"));
    		dealer.setSource(DeviceManagerUtil.convertBeanValueToString(myBean, "source"));
    		dealer.setPodLogLevel(DeviceManagerUtil.convertBeanValueToInt(myBean, "pod_log_level"));
    		dealer.setPodFlashLogLevel(DeviceManagerUtil.convertBeanValueToString(myBean, "pod_flash_log_level"));
    		dealer.setPodLogLimit(DeviceManagerUtil.convertBeanValueToInt(myBean, "pod_log_limit"));
    		dealer.setPodhibernate(DeviceManagerUtil.convertBeanValueToBoolean(myBean, "pod_hibernate"));
    		dealer.setPodRandomize(DeviceManagerUtil.convertBeanValueToBoolean(myBean, "pod_randomize"));
    		dealer.setName(DeviceManagerUtil.convertBeanValueToString(myBean, "name"));
    		dealer.setAddress1(DeviceManagerUtil.convertBeanValueToString(myBean, "address_1"));
    		dealer.setAddress2(DeviceManagerUtil.convertBeanValueToString(myBean, "address_2"));
    		dealer.setAddress3(DeviceManagerUtil.convertBeanValueToString(myBean, "address_3"));
    		
    		dealer.setCity(DeviceManagerUtil.convertBeanValueToString(myBean, "city"));
    		dealer.setState(DeviceManagerUtil.convertBeanValueToString(myBean, "state"));
    		dealer.setSubRegion(DeviceManagerUtil.convertBeanValueToString(myBean, "sub_region"));
    		dealer.setZip(DeviceManagerUtil.convertBeanValueToString(myBean, "zip"));
    		dealer.setBusinessCenter(DeviceManagerUtil.convertBeanValueToString(myBean, "business_center"));
    		dealer.setTaxId(DeviceManagerUtil.convertBeanValueToString(myBean, "tax_id"));
    		
    		dealer.setZone(DeviceManagerUtil.convertBeanValueToString(myBean, "zone"));
    		dealer.setCompanyId(DeviceManagerUtil.convertBeanValueToInt(myBean, "company_id"));
    		dealer.setCountryId(DeviceManagerUtil.convertBeanValueToInt(myBean, "country_id"));
    		//TODO
    		//dealer.setCreateDate(DeviceManagerUtil.convertBeanValueToTimeStamp(myBean, "create_date"));
    		dealer.setRegionId(DeviceManagerUtil.convertBeanValueToInt(myBean, "region_id"));
    		dealer.setDbAdminComment(DeviceManagerUtil.convertBeanValueToString(myBean, "dbadmin_comment"));
    		dealer.setMarketCode(DeviceManagerUtil.convertBeanValueToString(myBean, "market_code"));
    		dealer.setEmail(DeviceManagerUtil.convertBeanValueToString(myBean, "email"));
    		dealer.setOwner(DeviceManagerUtil.convertBeanValueToString(myBean, "owner"));
    		
    	}
    	return dealer;
	}

}
