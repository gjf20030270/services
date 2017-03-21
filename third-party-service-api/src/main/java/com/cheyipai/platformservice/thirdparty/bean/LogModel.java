package com.cheyipai.platformservice.thirdparty.bean;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Created by gongjunfeng on 2017/3/15.
 */
public class LogModel implements Serializable {

    private String serviceType;
    private long takeTime;
    private String thirdUri;
    private String thirdParams;
    private String thirdResponse;
    private String result;
    private String param;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public long getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(long takeTime) {
        this.takeTime = takeTime;
    }

    public String getThirdUri() {
        return thirdUri;
    }

    public void setThirdUri(String thirdUri) {
        this.thirdUri = thirdUri;
    }

    public String getThirdParams() {
        return thirdParams;
    }

    public void setThirdParams(String thirdParams) {
        this.thirdParams = thirdParams;
    }

    public String getThirdResponse() {
        return thirdResponse;
    }

    public void setThirdResponse(String thirdResponse) {
        this.thirdResponse = thirdResponse;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString(){
        return MessageFormat.format("[{0}|{1}|{2}|{3}|{4}|{5}|{6}]", serviceType, takeTime, thirdUri, thirdParams, thirdResponse, param, result);
    }

}
