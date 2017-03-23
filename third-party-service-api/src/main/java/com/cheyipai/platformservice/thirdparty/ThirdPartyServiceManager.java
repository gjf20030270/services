package com.cheyipai.platformservice.thirdparty;

import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.bean.Chain;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.utils.ThirdPartyServiceUtil;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Created by jiamingku on 2017/3/8.
 */
public class ThirdPartyServiceManager {
    public static final Logger LOG = Logger.getLogger(ThirdPartyServiceManager.class);

    public static ThirdPartyServiceManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 1.根据请求参数中的service_type获取链条
     * 2.执行链条
     * 3.返回结果
     * @param requestParmaMap
     * @return
     */
    public ResultMap getThirdPartyServiceResult(Map<String, String> requestParmaMap) {

        ResultMap ret = ResultMap.getResultMap(BusinessStatusEnum.FAIL);
        // 1.
        Chain thirdPartyServiceChain = ThirdPartyServiceUtil.getThirdPartyServiceChainByServiceType
                (requestParmaMap.get(Constants.SERVICE_TYPE));
        if (thirdPartyServiceChain == null) {
            return ResultMap.getResultMap(BusinessStatusEnum.SERVICE_NOT_EXISTS);
        }
        // 2.
        thirdPartyServiceChain.excuteService(requestParmaMap, ret);
        // 3.
        return ret;
    }

    private static class LazyHolder {
        private static final ThirdPartyServiceManager INSTANCE = new ThirdPartyServiceManager();
    }
}
