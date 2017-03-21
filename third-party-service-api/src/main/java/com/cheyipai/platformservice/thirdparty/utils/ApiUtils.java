package com.cheyipai.platformservice.thirdparty.utils;

import com.cheyipai.platformservice.thirdparty.bean.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2017/3/9.
 */
public class ApiUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ApiUtils.class);
    /**
     * push request params key-value to map, the values are all url decoded
     *
     * @param request
     * @param excludes
     * @return
     */
    public final static Map<String, String> getRequestParamMap(HttpServletRequest request, String... excludes) {
        Map<String, String> requestParamsMap = new HashMap();
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String param = e.nextElement();
            String value = request.getParameter(param);
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("getRequestParamMap(HttpServletRequest,String ...e) - [%s=>%s]",
                        param, value));
            }
            boolean isExclude = false;
            for (String x : excludes) {
                if (param.equals(x)) {
                    isExclude = true;
                    break;
                }
            }
            if (value != null && !isExclude) {
                requestParamsMap.put(param, value);
            }
        }
        return requestParamsMap;
    }
    public final static Map<String, String> getExcludedMap(Map<String,String> oriMap ,String... excludes) {

        Map<String, String> destMap = new HashMap();
        if(oriMap == null || oriMap.size() == 0 ){
            return destMap;
        }
        Map<String,String> m = oriMap;
        for(Map.Entry<String,String> entry : m.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("getRequestParamMap(HttpServletRequest,String ...e) - [%s=>%s]",
                        key, value));
            }
            boolean isExclude = false;
            for (String x : excludes) {
                if (x.equals(key)) {
                    isExclude = true;
                    break;
                }
            }
            if (value != null && !isExclude) {
                destMap.put(key, value);
            }
        }
        return destMap;
    }
    public final static Map<String,String> sortMapByKey(Map<String,String> oriMap){
        Map<String, String> sortedMap = new TreeMap<>();
        Map<String, String> m = oriMap;
        if(m == null || m.size() == 0){
            return sortedMap;
        }
        for (String key : m.keySet()) {
            sortedMap.put(key, m.get(key));
        }
        return sortedMap;
    }
    public final static String mapToString(Map<String,String> map){
        Map<String, String> m = map;
        if(m == null || m.size() == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder("");
        for (String key : m.keySet()) {
            String value = m.get(key);
            if(StringUtils.isNotBlank(value)){
                builder.append(key).append(value);
            }
        }
        return builder.toString();
    }
    public final static String mapToString(Map<String,String> map,String deli){
        Map<String, String> m = map;
        if(m == null || m.size() == 0){
            return "";
        }
        if(StringUtils.isBlank(deli)){
            deli = Constants.DELIMITER;
        }
        StringBuilder builder = new StringBuilder("");
        for (String key : m.keySet()) {
            String value = m.get(key);
            if(StringUtils.isNotBlank(value)){
                builder.append(key).append(value).append(deli);
            }
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
    public final static boolean isExpiredTimeMinute(long time,int amount){
        Date nowTime = new Date();
        Date addedTime = DateUtils.addMinutes(new Date(time), amount);
        int cmp = DateUtils.truncatedCompareTo(addedTime, nowTime, Calendar.SECOND);
        if (cmp < 0) {
            return true;
        }
        return false;
    }
    public final static boolean isExpiredTimeSecond(long time,int amount){
        Date nowTime = new Date();
        Date addedTime = DateUtils.addSeconds(new Date(time), amount);
        int cmp = DateUtils.truncatedCompareTo(addedTime, nowTime, Calendar.SECOND);
        if (cmp < 0) {
            return true;
        }
        return false;
    }

}
