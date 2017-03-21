package com.cheyipai.platformservice.thirdparty.service;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.mapper.AccessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by miqi on 2017/3/7.
*/
@Service("accessServic")
public class AccessService {
    private static final Logger logger = LoggerFactory.getLogger(AccessService.class);
    @Resource
    private AccessMapper accessMapper;

    public List<Access> selectAccess(){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
        List<Access> access= accessMapper.selectAccess();
        return access;
    }
}
