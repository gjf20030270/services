package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.entity.AccountDb;
import org.apache.ibatis.annotations.Param;

/**
 * Created by gongjunfeng on 2017/3/14.
 */
public interface AccountMapper {

    AccountDb getAccountByAppkey(@Param("appKey")String appKey,@Param("channel")String channel,@Param("businessCode")String businessCode);
}
