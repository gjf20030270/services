package com.cheyipai.platformservice.thirdparty.service;

import com.cheyipai.platformservice.thirdparty.bean.Vendor;
import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.mapper.VendorMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by miqi on 2017/3/7.
*/
@Service("vendorServic")
public class VendorService {
    private static final Logger logger = LoggerFactory.getLogger(VendorService.class);
    @Resource
    private VendorMapper vendorMapper;

    public ResultMap insertVendor(Vendor vendor){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
        if (null != vendor){
            Gson gson = new Gson();
            int i = vendorMapper.insertVendor(vendor);
            if (i>0)
                rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        }
        return rm;
    }

    public ResultMap updateVendor(Vendor vendor){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
        if (null != vendor){
            int i = vendorMapper.updateVendor(vendor);
            if (i>0)
                rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        }
        return rm;
    }

    public List<Vendor> selectVendor(){
        List<Vendor> vendors= vendorMapper.selectVendor();
        return vendors;
    }

    public ResultMap deleteVendor(String id){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
        int i = vendorMapper.deleteVendor(id);
        if (i>0)
            rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        return rm;
    }

}
