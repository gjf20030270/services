package com.cheyipai.platformservice.thirdparty.dao.mapper;

import com.cheyipai.platformservice.thirdparty.entity.BrokerUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/6/23.
 */
public interface BrokerUserMapper {
    BrokerUser getUser(@Param("username") String userName, @Param("password") String password);
}
