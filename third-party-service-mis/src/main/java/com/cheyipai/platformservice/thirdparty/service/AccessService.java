package com.cheyipai.platformservice.thirdparty.service;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.mapper.AccessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by miqi on 2017/3/7.
*/
@Service("accessServic")
public class AccessService {
    private static final Logger logger = LoggerFactory.getLogger(AccessService.class);
    @Resource
    private AccessMapper accessMapper;

    public List<Access> selectAccess(){
        List<Access> access= accessMapper.selectAccess();
        return access;
    }

    public List<Access> getTotal(){
        List<Access> access= accessMapper.getTotal();
        List list = new ArrayList();
        Map map = null;
        for (Access a:access){
            map = new HashMap();
            map.put("total",a.getId());
            map.put("canal",a.getChannel());
            list.add(map);
        }
        return list;
    }
}
