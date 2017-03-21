package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.entity.AccessDetailDb;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
public interface AccessDetailMapper {

    int addAccessDetail(AccessDetailDb detail);

    List<AccessDetailDb> getAccessDetails();

    AccessDetailDb getAccessDetailByAccessId(long accessId);
}
