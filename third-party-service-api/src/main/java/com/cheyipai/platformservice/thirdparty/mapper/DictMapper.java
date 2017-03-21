package com.cheyipai.platformservice.thirdparty.mapper;

import com.cheyipai.platformservice.thirdparty.entity.DictDb;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjunfeng on 2017/3/17.
 */
public interface DictMapper {

    List<DictDb> getDicts(Map<String,String> params);

    DictDb getDictById(long id);

    int addDict(DictDb dict);

    int updateDict(DictDb dict);
}
