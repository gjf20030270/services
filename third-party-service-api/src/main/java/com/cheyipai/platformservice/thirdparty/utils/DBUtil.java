package com.cheyipai.platformservice.thirdparty.utils;

import com.cheyipai.platformservice.thirdparty.entity.*;
import com.cheyipai.platformservice.thirdparty.mapper.*;

import java.util.List;
import java.util.Map;

/**
 * Created by gongjunfeng on 2017/3/9.
 * 需等SpringUtils实例化好后才可以使用
 */
public class DBUtil {

    private AccessMapper accessMapper = null;

    private AccessDetailMapper accessDetailMapper;

    private ServiceVendorMapper serviceVendorMapper;

    private AccountMapper accountMapper;

    private DictMapper dictMapper;

    private DBUtil() {
        this.accessMapper = SpringUtils.getBean("accessMapper");
        this.accessDetailMapper = SpringUtils.getBean("accessDetailMapper");
        this.serviceVendorMapper = SpringUtils.getBean("serviceVendorMapper");
        this.accountMapper = SpringUtils.getBean("accountMapper");
        this.dictMapper = SpringUtils.getBean("dictMapper");
    }

    private static class LazyHolder {
        private static final DBUtil INSTANCE = new DBUtil();
    }

    public static DBUtil getInstance() {
        return LazyHolder.INSTANCE;
    }

    public int addAccess(AccessDb accessDb) {
        return accessMapper.addAccess(accessDb);
    }

    public List<AccessDb> getAccesses() {
        return accessMapper.getAccesses();
    }

    public int addAccessDetail(AccessDetailDb accessDetaiDb) {
        return accessDetailMapper.addAccessDetail(accessDetaiDb);
    }

    public List<AccessDetailDb> getAccessDetails() {
        return accessDetailMapper.getAccessDetails();
    }

    public List<ServiceVendorDb> getServiceVendors(Map<String, Object> paramMap) {
        return serviceVendorMapper.getServiceVendors(paramMap);
    }

    public AccessDetailDb getAccessDetailByAccessId(long accessId){
        return accessDetailMapper.getAccessDetailByAccessId(accessId);
    }
    public AccessDb getAccessByIdentifyCode(String identityCode){
        return accessMapper.getAccessByIdentifyCode(identityCode);
    }
    public AccountDb getAccountByAppKey(String appKey,String channel,String businessCode){
        return accountMapper.getAccountByAppkey(appKey,channel,businessCode);
    }
    public DictDb getDictById(long id){
        return this.dictMapper.getDictById(id);
    }
    public List<DictDb> getDicts(Map<String,String> params){
        return this.dictMapper.getDicts(params);
    }
    public int addDict(DictDb dict){
        return this.dictMapper.addDict(dict);
    }
    public int updateDict(DictDb dict){
        return this.dictMapper.updateDict(dict);
    }
}
