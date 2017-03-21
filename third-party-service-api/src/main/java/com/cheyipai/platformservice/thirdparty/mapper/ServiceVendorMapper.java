package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;

import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/7.
 */
public interface ServiceVendorMapper {

    /**
     * 现在只是获取生效的供应商信息
     *
     * @param params
     * @return
     */
    List<ServiceVendorDb> getServiceVendors(Map<String, Object> params);

    int addServiceVendor(ServiceVendorDb serviceVendorDb);

}
