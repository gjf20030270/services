package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.service.AccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
@Controller
@RequestMapping(ApiUrls.ACCESS)
public class AccessController {

    private static final Logger logger = LoggerFactory.getLogger(AccessController.class);
    @Resource
    private AccessService accessService;

    @RequestMapping(value = "/selectAccess")
    public String selectAccess(){
        return "access";
    }

    @ResponseBody
    @RequestMapping(value = "/accessInfo.json",method = {RequestMethod.GET, RequestMethod.POST})
    public Object accountInfoJson(HttpServletRequest request,HttpServletResponse response){
        String callTime = request.getParameter("callbackTime");
        Access aces = new Access();
        aces.setChannel(request.getParameter("channel"));
        aces.setAppKey(request.getParameter("appKey"));
        aces.setBusiCode(request.getParameter("busiCode"));
        aces.setVendorCode(request.getParameter("vendorCode"));
        aces.setIdentifyCode(request.getParameter("identifyCode"));
        aces.setCallbackTime(callTime);
        String thirdRequest = request.getParameter("thirdRequestParam");
        if (thirdRequest.equals("1"))thirdRequest=null;
        aces.setThirdRequestParam(thirdRequest);
        aces.setStatus(request.getParameter("status"));
        List<Access> access = accessService.selectAccess(aces);
        return access;
    }
}
