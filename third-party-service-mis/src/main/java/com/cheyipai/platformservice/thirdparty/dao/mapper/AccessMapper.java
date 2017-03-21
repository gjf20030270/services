package com.cheyipai.platformservice.thirdparty.dao.mapper;


import com.cheyipai.platformservice.thirdparty.bean.Access;

import java.util.List;

/**
 * Created by miqi on 2017/3/10.
 */
public interface AccessMapper {
    List<Access> getTotal();
    List<Access> selectAccess();
}
