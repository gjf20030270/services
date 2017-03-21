package com.cheyipai.platformservice.thirdparty;

import com.cheyipai.platformservice.thirdparty.bean.ProcessResult;
import com.cheyipai.platformservice.thirdparty.bean.RequestServiceConfig;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;

import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/6.
 */
public interface ThirdPartyService {

    ProcessResult excuteService(Map<String, String> requestConfigMap, ResultMap ret);

    RequestServiceConfig getRequestServiceConfig();

    boolean isExists(String key);

    String getServiceType();

}
