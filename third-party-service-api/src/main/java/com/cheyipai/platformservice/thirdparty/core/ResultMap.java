package com.cheyipai.platformservice.thirdparty.core;


import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;

import java.util.HashMap;

/**
 * Created by suncg on 15-1-5.
 */
public class ResultMap extends HashMap<String, Object> {

    private final String KEY_RESULT_CODE = "resultCode";
    private final String KEY_STATE_DESCRIPTION = "StateDescription";
    private final String KEY_DATA = "data";

    public ResultMap(String errorCode, String msg) {
        this.put(KEY_RESULT_CODE, errorCode);
        this.put(KEY_STATE_DESCRIPTION, msg);
    }

    public ResultMap(Integer errorCode, String msg) {
        this.put(KEY_RESULT_CODE, errorCode);
        this.put(KEY_STATE_DESCRIPTION, msg);
    }

    public ResultMap(BusinessStatusEnum status) {
        this.put(KEY_RESULT_CODE, status.getResultCode());
        this.put(KEY_STATE_DESCRIPTION, status.getStateDescription());
        this.put(KEY_DATA, new Object());
    }
    public ResultMap() {
    }

    public static ResultMap getResultMap(BusinessStatusEnum status) {
        ResultMap rm = new ResultMap(status);
        return rm;
    }

    public String getResultCode(){
        return (String)this.get(KEY_RESULT_CODE);
    }
    public String getStateDescription(){
        return (String)this.get(KEY_STATE_DESCRIPTION);
    }
    public Object getData(){
        return this.get(KEY_DATA);
    }
    public void setData(Object data) {
        this.put(KEY_DATA, data);
    }

    public void setResultCode(String code){
        this.put(KEY_RESULT_CODE, code);
    }

    public void setStateDescription(String msg){
        this.put(KEY_STATE_DESCRIPTION, msg);
    }
}
