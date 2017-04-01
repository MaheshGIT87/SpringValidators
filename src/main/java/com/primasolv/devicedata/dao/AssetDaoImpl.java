/**
 * 
 */
package com.primasolv.devicedata.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.springframework.stereotype.Repository;

import com.primasolv.devicedata.model.Asset;
import com.primasolv.devicedata.util.DeviceManagerUtil;

/**
 * @author kiran
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class AssetDaoImpl implements AssetDao {

	private  static final String SQL_ASSET_BY_SERIAL_NO = "select * from asset where serial_number='%s'";
	private  static final String SQL_ASSET_BY_ASSET_IDS = "select * from asset where id in (%s)";
	private  static final String SQL_GET_ALL_ASSETS_SERIAL_NO = "select serial_number from asset";
	
	
	/* (non-Javadoc)
	 * @see com.primasolv.devicedata.dao.AssetDao#getAssetBySerialNumber(java.lang.String)
	 */
	@Override
	public Asset getAssetBySerialNumber(String SCHEMA_NAME, String serialNumber) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		Asset asset = new Asset();
		try {
			String sql = String.format(SQL_ASSET_BY_SERIAL_NO, serialNumber);
			Collection<DynaBean> result = jcm.execute(sql);
			List<Asset> assetList = new ArrayList<Asset>();
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            assetList.add(convertBeanToAsset(myBean));
	        }
	        if(!assetList.isEmpty()) {
	        	asset = assetList.get(0);
	        }
		} catch (Exception e) {
			throw e;
		}
		return asset;
	}

	
	@Override
	public List<Asset> getAssetByIds(String SCHEMA_NAME, List<Integer> assetIds) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setConnection(SCHEMA_NAME.toLowerCase());
		List<Asset> assetList = new ArrayList<Asset>();
		try {
			String sql = String.format(SQL_ASSET_BY_ASSET_IDS, DeviceManagerUtil.generateCommaSeperated(assetIds));
			Collection<DynaBean> result = jcm.execute(sql);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            assetList.add(convertBeanToAsset(myBean));
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return assetList;
	}
	
	@Override
	public List<String> getAllAssetSerialNos(String SCHEMA_NAME) throws Exception {
		JdbcConnectionManager jcm = new JdbcConnectionManager();
		jcm.setNewConnection(SCHEMA_NAME.toLowerCase());
		List<String> assetList = new ArrayList<String>();
		
		try {
			Collection<DynaBean> result = jcm.execute(SQL_GET_ALL_ASSETS_SERIAL_NO);
	        for (Object aResult : result) {
	            DynaBean myBean = (DynaBean) aResult;
	            assetList.add(DeviceManagerUtil.convertBeanValueToString(myBean, "serial_number"));
	        }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return assetList;
	}
	
	/**
     * 
     * @param myBean
     * @return
     */
    private Asset convertBeanToAsset(DynaBean myBean) {
    	Asset asset = new Asset();
    	if(myBean != null) {
    		asset.setId(DeviceManagerUtil.convertBeanValueToInt(myBean, "id"));
    		asset.setAppVersion(DeviceManagerUtil.convertBeanValueToString(myBean, "app_version"));
    		asset.setDealerId(DeviceManagerUtil.convertBeanValueToInt(myBean, "dealer_id"));
    		asset.setOsVersion(DeviceManagerUtil.convertBeanValueToString(myBean, "os_version"));
    		asset.setPortalId(DeviceManagerUtil.convertBeanValueToInt(myBean, "portal_id"));
    		asset.setSerialNumber(DeviceManagerUtil.convertBeanValueToString(myBean, "serial_number"));
    		asset.setSource(DeviceManagerUtil.convertBeanValueToString(myBean, "source"));
    		asset.setApplicationEnvironmentId(DeviceManagerUtil.convertBeanValueToInt(myBean, "application_environment_id"));
    		asset.setDeviceMgrUrl(DeviceManagerUtil.convertBeanValueToString(myBean, "devicemgr_url"));
    		asset.setSocChipId(DeviceManagerUtil.convertBeanValueToString(myBean, "soc_chip_id"));
    		asset.setIoCardChipId(DeviceManagerUtil.convertBeanValueToString(myBean, "io_card_chip_id"));
    		asset.setPodLogLevel(DeviceManagerUtil.convertBeanValueToInt(myBean, "pod_log_level"));
    		asset.setPodFlashLogLevel(DeviceManagerUtil.convertBeanValueToString(myBean, "pod_flash_log_level"));
    		asset.setPodLogLimit(DeviceManagerUtil.convertBeanValueToInt(myBean, "pod_log_limit"));
    		asset.setPodHibernate(DeviceManagerUtil.convertBeanValueToBoolean(myBean, "pod_hibernate"));
    		asset.setPodRandomize(DeviceManagerUtil.convertBeanValueToBoolean(myBean, "pod_randomize"));
    		asset.setType(DeviceManagerUtil.convertBeanValueToString(myBean, "type"));
    		asset.setIntegrity(DeviceManagerUtil.convertBeanValueToString(myBean, "integrity"));
    		asset.setOwner(DeviceManagerUtil.convertBeanValueToString(myBean, "owner"));
    		asset.setPodSshdEnable(DeviceManagerUtil.convertBeanValueToBoolean(myBean, "pod_sshd_enable"));
    	}
        return asset;
    }

}
