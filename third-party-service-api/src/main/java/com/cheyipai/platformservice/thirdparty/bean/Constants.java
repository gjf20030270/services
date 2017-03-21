package com.cheyipai.platformservice.thirdparty.bean;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class Constants {
    /**
     * 4s 服务
     */
    public static final String THIRD_PARTY_SERVICE_TYPE_4S = "4S";

    /**
     * 违章 服务
     */
    public static final String THIRD_PARTY_SERVICE_TYPE_WZ = "WZ";

    public static final String APP_KEY = "app_key";
    /**
     * 签名
     */
    public static final String SIGN = "sign";
    /**
     * 时间戳
     */
    public static final String TIME_STAMP = "time_stamp";
    /**
     * 请求渠道
     */
    public static final String CHANNEL = "channel";
    /**
     * 业务编码
     */
    public static final String BUSINESS_CODE = "business_code";
    /**
     * 服务类型
     */
    public static final String SERVICE_TYPE = "service_type";
    /**
     * 唯一标识
     */
    public static final String REQ_PARAM_IDENTIFY_CODE = "identify_code";
    /**
     * 接口过期时间 分钟
     */
    public static final int EXPIRED_TIME_MINUTE = 5 ;
    /**
     * 分隔符
     */
    public static final String DELIMITER = "_";

    public static final String[] CHECK_NAMES = {APP_KEY,TIME_STAMP,CHANNEL,BUSINESS_CODE,SERVICE_TYPE,SIGN};

    public static final String SERVICE_VENDOR_JUHE = "JUHE";

    public static final String SERVICE_VENDOR_JISU = "JISU";

    public static final String JUHE_BUSINESS_TYPE_CITY ="JUHE_CITY" ;

}
