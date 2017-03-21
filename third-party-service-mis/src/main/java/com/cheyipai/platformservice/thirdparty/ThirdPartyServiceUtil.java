package com.cheyipai.platformservice.thirdparty;

import com.cheyipai.platformservice.thirdparty.bean.ThirdPartyServiceConstants;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceUtil {


    public static boolean is4SService(String serviceType) {
        return isEqual(serviceType, ThirdPartyServiceConstants.THIRD_PARTY_SERVICE_TYPE);
    }


    public static boolean isEqual(String src, String anotherStr) {
        if (null == src) {
            return false;
        }
        return src.trim().equalsIgnoreCase(anotherStr);
    }
}
