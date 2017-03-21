package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.service.AccessService;
import com.cheyipai.platformservice.thirdparty.utils.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/accesstotal.json",method = {RequestMethod.GET, RequestMethod.POST})
    public String getAccessTotal(){
        List<Access> access = accessService.getTotal();
        ResultMap resultMap = new ResultMap(BusinessStatusEnum.SUCCESS);
        resultMap.setData(access);
        JsonMapper jm = JsonMapper.buildNormalBinder();
        return jm.toJson(resultMap);
    }
}
