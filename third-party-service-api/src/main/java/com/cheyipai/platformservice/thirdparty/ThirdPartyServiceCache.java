package com.cheyipai.platformservice.thirdparty;


import com.cheyipai.platformservice.thirdparty.bean.Chain;

/**
 * Created by jiamingku on 2017/3/6.
 */
public interface ThirdPartyServiceCache {

    void reloadThirdPartyServiceDbs();

    ThirdPartyService getThirdPartyService(String serviceType);

    Chain getThirdPartyServiceChain(String serviceType);

}
