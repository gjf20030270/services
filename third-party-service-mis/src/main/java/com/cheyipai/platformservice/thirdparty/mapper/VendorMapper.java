package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.bean.Vendor;

import java.util.List;

/**
 * Created by jiamingku on 2017/3/7.
 */
public interface VendorMapper {
    int insertVendor(Vendor vendor);
    int updateVendor(Vendor vendor);
    List<Vendor> selectVendor(Vendor vendor);
    int deleteVendor(String id);
}
