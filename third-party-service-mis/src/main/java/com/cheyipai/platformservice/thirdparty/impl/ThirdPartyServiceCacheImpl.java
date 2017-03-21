package com.cheyipai.platformservice.thirdparty.impl;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceCache;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceException;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceUtil;
import com.cheyipai.platformservice.thirdparty.bean.ThirdPartyServiceDb;
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

    private static Logger LOG = LoggerFactory.getLogger(ThirdPartyServiceCacheImpl.class);

    public static List<ThirdPartyService> thirdPartyServices = new ArrayList<>();

    public static Map<String, ThirdPartyService> thirdPartyServiceMap = new HashMap<>();

    /**
     * 1.载入数据库数据 <br/>
     * 2.构建服务数据 <br/>
     * 3.排序 <br/>
     * 4.换引用 <br/>
     * 5.构建map<br/>
     * 6.初始化 <br/>
     */
    @Override
    public void reloadPartyServiceDbs() {
        List<ThirdPartyServiceDb> thirdPartyServiceDbs = null;
        ThirdPartyService thirdPartyService = null;
        // 1.


        if (thirdPartyServiceDbs == null) {
            LOG.error("从数据库获取第三方服务记录为空!");
            throw new ThirdPartyServiceException("从数据库获取第三方服务据为空!");
        }

        if (thirdPartyServiceDbs != null) {
            for (ThirdPartyServiceDb thirdPartyServiceDb : thirdPartyServiceDbs) {
                if (ThirdPartyServiceUtil.is4SService(thirdPartyServiceDb.getServiceCode())) {

                }

            }
        }



    }

    @Override
    public ThirdPartyService getThirdPartyService(String serviceCode) {
        return null;
    }
}
