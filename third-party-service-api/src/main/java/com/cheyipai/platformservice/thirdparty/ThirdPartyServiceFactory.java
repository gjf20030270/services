package com.cheyipai.platformservice.thirdparty;

import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.impl.WzThirdPartyService;
import com.cheyipai.platformservice.thirdparty.impl.wz.JhWzThirdPartyService;
import com.cheyipai.platformservice.thirdparty.impl.wz.JsWzThirdPartyService;
import com.cheyipai.platformservice.thirdparty.utils.ThirdPartyServiceUtil;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceFactory {

    /**
     * 根据数据库配置类型来进行创建第三方服务
     *
     * @param
     * @return
     * @throws ThirdPartyServiceException
     */
    public static ThirdPartyService getThirdPartyServiceFilterByDbType(ServiceVendorDb serviceVendorDb) throws
            ThirdPartyServiceException {
        ThirdPartyService thirdPartyService = null;
        String error = "";
        if (serviceVendorDb == null) {
            throw new ThirdPartyServiceException("初始化第三方服务错误 原因:thirdPartyServiceDb=null");
        } else if (ThirdPartyServiceUtil.is4SService("")) {

        } else if (ThirdPartyServiceUtil.isWzService(serviceVendorDb.getServiceType())) {
            if (ThirdPartyServiceUtil.isJhWzService(serviceVendorDb.getCode())) {
                thirdPartyService = new JhWzThirdPartyService(serviceVendorDb);
            }else if (ThirdPartyServiceUtil.isJsWzService(serviceVendorDb.getCode())) {
                thirdPartyService = new JsWzThirdPartyService(serviceVendorDb);
            }
        }

        return thirdPartyService;
    }
}
