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
     * @param requestConfigMap
     * @return
     */
    public ResultMap getThirdPartyServiceResult(Map<String, String> requestConfigMap) {

        ResultMap ret = ResultMap.getResultMap(BusinessStatusEnum.FAIL);
        // 1. 根据请求参数获取对应的服务
        Chain thirdPartyServiceChain = ThirdPartyServiceUtil.getThirdPartyServiceChainByServiceType
                (requestConfigMap.get(Constants.SERVICE_TYPE));

        if (thirdPartyServiceChain == null) {
            return ret;
        }

        thirdPartyServiceChain.excuteService(requestConfigMap, ret);

        // 2.执行 数据

        return ret;

    }

    private static class LazyHolder {
        private static final ThirdPartyServiceManager INSTANCE = new ThirdPartyServiceManager();
    }

}
