package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.service.AccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    @RequestMapping(value = "/accessInfo.json")
    public Object accountInfoJson(){
        List<Access> access = accessService.selectAccess();
        return access;
    }
}
