package com.cheyipai.platformservice.thirdparty;

/**
 * Created by jiamingku on 2017/3/6.
 */
public interface ThirdPartyServiceCache {

    void reloadPartyServiceDbs();

    ThirdPartyService getThirdPartyService(String serviceCode);
}
