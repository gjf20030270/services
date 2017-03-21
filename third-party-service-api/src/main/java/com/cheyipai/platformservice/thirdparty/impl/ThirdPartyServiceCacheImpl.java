package com.cheyipai.platformservice.thirdparty.impl;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceCache;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceException;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceFactory;
import com.cheyipai.platformservice.thirdparty.bean.Chain;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.mapper.ServiceVendorMapper;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import com.cheyipai.platformservice.thirdparty.utils.ExceptionUtil;
import com.cheyipai.platformservice.thirdparty.utils.ThirdPartyServiceUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceCacheImpl implements ThirdPartyServiceCache {

    public static List<ThirdPartyService> thirdPartyServices = new ArrayList<>();

    public static List<ServiceVendorDb> serviceVendorDbs = new ArrayList<>();
    public static Map<String, ThirdPartyService> thirdPartyServiceMap = new HashMap<>();
    public static Map<String, Chain> thirdPartyServiceChainMap = new HashMap<>();
    private static Logger LOG = LoggerFactory.getLogger(ThirdPartyServiceCacheImpl.class);

    public static ThirdPartyServiceCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public void reloadThirdPartyServiceDbs() {

        List<ServiceVendorDb> serviceVendorDbsTemp = null;
        ThirdPartyService thirdPartyService = null;
        List<ThirdPartyService> thirdPartyServicesTemp = new ArrayList<>();
        Map<String, Chain> thirdPartyServiceChainMapTemp = new HashMap<>();

        // 1.
        serviceVendorDbsTemp = DBUtil.getInstance().getServiceVendors(new HashMap<String, Object>());

        if (serviceVendorDbsTemp == null) {
            LOG.error("从数据库获取第三方服务记录为空!");
            throw new ThirdPartyServiceException("从数据库获取第三方服务据为空!");
        }

        if (serviceVendorDbsTemp != null) {
            for (ServiceVendorDb serviceVendorDb : serviceVendorDbsTemp) {
                try {
                    // 2
                    thirdPartyService = ThirdPartyServiceFactory.getThirdPartyServiceFilterByDbType(serviceVendorDb);
                    if (thirdPartyService != null) {
                        thirdPartyServicesTemp.add(thirdPartyService);
                    }
                } catch (Exception e) {
                    String traceInfo = ExceptionUtil.getExceptionTraceInfo(e);
                    LOG.error("载入ThirdPartyService失败,原因[" + e.getMessage() + "] 继续加载下一条第三方服务");
                    LOG.error(traceInfo);
                }
            }
        }
        // 3
        thirdPartyServiceChainMapTemp = aggregationThirdPartServiceChain(thirdPartyServicesTemp);
        // 4.
        thirdPartyServices = thirdPartyServicesTemp;
        thirdPartyServiceChainMap = thirdPartyServiceChainMapTemp;
        serviceVendorDbs = serviceVendorDbsTemp;
        // 5.
        ThirdPartyServiceUtil.sortThirdPartyService(thirdPartyServiceChainMap);
    }


    public Map<String, Chain> aggregationThirdPartServiceChain(
            List<ThirdPartyService> thirdPartyServices) {

        Map<String, Chain> thirdPartyServicChainMap = new HashMap<>();
        if (null == thirdPartyServices || thirdPartyServices.size() == 0) {
            return thirdPartyServicChainMap;
        }

        for (ThirdPartyService thirdPartyService : thirdPartyServices) {
            if (thirdPartyService == null) {
                continue;
            }
            Chain thirdPartyServiceChain = thirdPartyServicChainMap.get(thirdPartyService.getServiceType());

            if (null == thirdPartyServiceChain) {
                // wz
                thirdPartyServiceChain = new Chain();
                thirdPartyServiceChain.addThirdPartyService(thirdPartyService);
                thirdPartyServicChainMap.put(thirdPartyService.getServiceType(), thirdPartyServiceChain);
            } else {
                thirdPartyServiceChain.addThirdPartyService(thirdPartyService);
            }
        }
        return thirdPartyServicChainMap;
    }


    @Override
    public ThirdPartyService getThirdPartyService(String serviceType) {
        ThirdPartyService thirdPartyService = null;
        if (StringUtils.isBlank(serviceType)) {
            return thirdPartyService;
        }
        Map<String, ThirdPartyService> thirdPartyServiceMap = getThirdPartyServiceMap();
        return thirdPartyServiceMap.get(serviceType);
    }


    @Override
    public Chain getThirdPartyServiceChain(String serviceType) {
        Chain thirdPartyServiceChain = null;
        if (StringUtils.isBlank(serviceType)) {
            return thirdPartyServiceChain;
        }

        return getThirdPartyServiceChainMap().get(serviceType);
    }

    public Map<String, Chain> getThirdPartyServiceChainMap() {
        if (thirdPartyServices == null || thirdPartyServices.size() == 0) {
            synchronized (this) {
                if (thirdPartyServices == null || thirdPartyServices.size() == 0) {
                    reloadThirdPartyServiceDbs();
                }
            }
        }
        return ThirdPartyServiceCacheImpl.thirdPartyServiceChainMap;
    }

    public Map<String, ThirdPartyService> getThirdPartyServiceMap() {
        if (thirdPartyServices == null || thirdPartyServices.size() == 0) {
            synchronized (this) {
                if (thirdPartyServices == null || thirdPartyServices.size() == 0) {
                    reloadThirdPartyServiceDbs();
                }
            }
        }
        return ThirdPartyServiceCacheImpl.thirdPartyServiceMap;
    }

    private static class LazyHolder {
        private static final ThirdPartyServiceCache INSTANCE = new ThirdPartyServiceCacheImpl();
    }

}
