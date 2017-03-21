package com.cheyipai.platformservice.thirdparty.utils;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceCache;
import com.cheyipai.platformservice.thirdparty.bean.Chain;
import com.cheyipai.platformservice.thirdparty.bean.RequestServiceConfig;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.impl.ThirdPartyServiceCacheImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceUtil {

    private static ThirdPartyServiceCache thirdPartyServiceCache = ThirdPartyServiceCacheImpl.getInstance();

    public static boolean is4SService(String serviceType) {
        return isEqual(serviceType, Constants.THIRD_PARTY_SERVICE_TYPE_4S);
    }

    public static boolean isWzService(String serviceType) {
        return isEqual(serviceType, Constants.THIRD_PARTY_SERVICE_TYPE_WZ);
    }

    public static boolean isJhWzService(String serviceType) {
        return isEqual(serviceType, Constants.SERVICE_VENDOR_JUHE);
    }

    public static boolean isJsWzService(String serviceType) {
        return isEqual(serviceType, Constants.SERVICE_VENDOR_JISU);
    }

    public static boolean isEqual(String src, String anotherStr) {
        if (null == src) {
            return false;
        }
        return src.trim().equalsIgnoreCase(anotherStr);
    }


    public static ThirdPartyService getThirdPartyServiceByServiceType(String serviceType) {
        return thirdPartyServiceCache.getThirdPartyService(serviceType);
    }

    public static Chain getThirdPartyServiceChainByServiceType(String serviceType) {
        return thirdPartyServiceCache.getThirdPartyServiceChain(serviceType);
    }

    public static String checkRequstUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;

        return url;
    }


    public static void sortThirdPartyService(Map<String, Chain> thirdPartyServiceChainMap) {
        if (null == thirdPartyServiceChainMap || thirdPartyServiceChainMap.size() == 0) {
            return;
        }

        Chain thirdPartyServiceChain = null;
        for (Map.Entry<String, Chain> entry : thirdPartyServiceChainMap.entrySet()) {
            thirdPartyServiceChain = entry.getValue();
            if (null == thirdPartyServiceChain) {
                continue;
            }
            Collections.sort(thirdPartyServiceChain.getChainElements(),
                    new Comparator<ThirdPartyService>() {
                        @Override
                        public int compare(ThirdPartyService o1, ThirdPartyService o2) {
                            return o1.getRequestServiceConfig().getLevel() - o2.getRequestServiceConfig().getLevel();
                        }
                    });
        }
    }
}
