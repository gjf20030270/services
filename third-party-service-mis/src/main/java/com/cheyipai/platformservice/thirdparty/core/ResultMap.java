package com.cheyipai.platformservice.thirdparty.core;


import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;

import java.util.HashMap;

/**
 * Created by suncg on 15-1-5.
 */
public class ResultMap extends HashMap<String, Object> {


    private final String KEY_ERROR_CODE = "resCode";
    private final String KEY_MESSAGE = "msg";
    private final String KEY_DATAS = "data";

    public ResultMap(String errorCode, String msg){
        this.put(KEY_ERROR_CODE, errorCode);
        this.put(KEY_MESSAGE, msg);
    }

    public ResultMap(Integer errorCode, String msg){
        this.put(KEY_ERROR_CODE, errorCode);
        this.put(KEY_MESSAGE, msg);
    }

    public ResultMap(BusinessStatusEnum status){
        this.put(KEY_ERROR_CODE,status.getStatus());
        this.put(KEY_MESSAGE,status.getStatusmsg());
        this.put(KEY_DATAS,null);
    }

    public static ResultMap getResultMap(BusinessStatusEnum status){
        ResultMap rm = new ResultMap(status);
        return rm;
    }
    public void setData(Object data){
        this.put(KEY_DATAS, data);
    }


}
