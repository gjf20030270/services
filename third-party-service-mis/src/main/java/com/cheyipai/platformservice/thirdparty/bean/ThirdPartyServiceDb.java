package com.cheyipai.platformservice.thirdparty.bean;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceDb {
    private long id;
    private String code;


    private String serviceCode;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setId(long id) {
        this.id = id;
    }
}
