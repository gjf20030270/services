package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.entity.AccessDb;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
public interface AccessMapper {

    int addAccess(AccessDb access);

    List<AccessDb> getAccesses();

    AccessDb getAccessByIdentifyCode(String identifyCode);


}
