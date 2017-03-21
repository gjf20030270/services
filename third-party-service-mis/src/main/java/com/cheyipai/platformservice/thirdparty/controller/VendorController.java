package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.Vendor;
import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.service.VendorService;
import com.cheyipai.platformservice.thirdparty.utils.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
@Controller
@RequestMapping(ApiUrls.VENDOR)
public class VendorController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Resource
    private VendorService vendorService;

    @RequestMapping(value = "/selectVendor")
    public String selectVendor(HttpServletRequest request){
        return "vendor";
    }

    @ResponseBody
    @RequestMapping(value = "/vendorInfo.json")
    public Object vendorInfoJson(){
        List<Vendor> vendor = vendorService.selectVendor();
        return vendor;
    }

    @ResponseBody
    @RequestMapping(value = "/optVendor",method = {RequestMethod.GET, RequestMethod.POST})
    public String insertVendor(Vendor vendor,HttpServletRequest request){
        JsonMapper jm = JsonMapper.buildNormalBinder();
        ResultMap rm = null;
        String id = vendor.getId().toString();
        if("-1".equals(id)){
            rm = vendorService.insertVendor(vendor);
        }else{
            rm = vendorService.updateVendor(vendor);
        }
        return jm.toJson(rm);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteVendor",method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteVendor(@RequestParam String id){
        JsonMapper jm = JsonMapper.buildNormalBinder();
        ResultMap rm = vendorService.deleteVendor(id);
        return jm.toJson(rm);
    }
}
