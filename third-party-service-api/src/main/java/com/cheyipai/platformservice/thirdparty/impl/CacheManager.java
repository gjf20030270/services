package com.cheyipai.platformservice.thirdparty.impl;

import com.cheyipai.cachecloud.redis.Cache;
import com.cheyipai.cachecloud.util.CacheClient;
import com.cheyipai.platformservice.thirdparty.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by gongjunfeng on 2017/3/20.
 */
public class CacheManager {

    private static final Logger LOG = LoggerFactory.getLogger(CacheManager.class);

    public int KEY_EXPIRETIME = 1 * 60 * 60;           //redis key 过期时间
    public static final String REGIN = "mapi_busi";     //key前缀,多个项目用同一个redis,用来区分项目，避免key值冲突覆盖

    public String get(String key){
        if(key == null){
            return null;
        }
        Cache cache = null;
        String value = null;
        try{
            cache = CacheClient.getInstance(REGIN, KEY_EXPIRETIME);
            value = (String) cache.get(key);
        }catch(Exception e){
            LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
        }finally{
            returnResource(cache);
        }
        return value;
    }
    public Object getObject(String key){
        if(key == null){
            return null;
        }
        Cache cache = null;
        Object value = null;
        try{
            cache = CacheClient.getInstance(REGIN, KEY_EXPIRETIME);
            value = cache.get(key);
        }catch(Exception e){
            LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
        }finally{
            returnResource(cache);
        }
        return value;
    }
    public void returnResource(Cache cache){
        if(cache!=null){
            try {
                cache.destroy();
            } catch (Exception e) {
                LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
            }
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue queue;
        ConcurrentLinkedQueue linkedQueue;
        PriorityBlockingQueue priorityBlockingQueue;
    }

}
