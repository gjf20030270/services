package com.cheyipai.platformservice.thirdparty;

import com.cheyipai.platformservice.thirdparty.bean.ThirdPartyServiceDb;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceFactory {

    /**
     * 根据数据库配置类型来进行创建第三方服务
     *
     * @param thirdPartyServiceDb
     * @return
     * @throws ThirdPartyServiceException
     */
    public static ThirdPartyService getThirdPartyServiceFilterByDbType(ThirdPartyServiceDb thirdPartyServiceDb) throws
            ThirdPartyServiceException {
        ThirdPartyService thirdPartyService = null;
        String error = "";
        if (thirdPartyServiceDb == null) {
            throw new ThirdPartyServiceException("初始化第三方服务错误 原因:thirdPartyServiceDb=null");
        } else if (true) {

        }

        return thirdPartyService;
    }
}
