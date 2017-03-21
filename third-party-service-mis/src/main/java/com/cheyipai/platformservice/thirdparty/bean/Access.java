package com.cheyipai.platformservice.thirdparty.bean;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/9.
 */
public class Access {
    private Integer id;
    private String channel;//渠道pc，android等
    private String appKey;//调用方app_key
    private String busiCode;//业务代码，例如pc端的登陆,pc端的查询,区分一二级请求
    private String vendorCode;//服务商编码
    private String identifyCode;//服务的唯一码，代表可以确定一次查询的唯一标志',
    private String thirdIdentifyId;//第三方回调唯一标志
    private Date createTime;
    private Date updateTime;
    private Date callbackTime;//'回调时间'
    private String status;//状态 1 有效 0 无效',

    private String requestParam;//'请求参数json创建'
    private String thirdRequestParam;//第三方请求参数json创建
    private String responResult;//'相应结果'
    private String thirdResponResult;//第三方相应结果

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    public String getThirdIdentifyId() {
        return thirdIdentifyId;
    }

    public void setThirdIdentifyId(String thirdIdentifyId) {
        this.thirdIdentifyId = thirdIdentifyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getThirdRequestParam() {
        return thirdRequestParam;
    }

    public void setThirdRequestParam(String thirdRequestParam) {
        this.thirdRequestParam = thirdRequestParam;
    }

    public String getResponResult() {
        return responResult;
    }

    public void setResponResult(String responResult) {
        this.responResult = responResult;
    }

    public String getThirdResponResult() {
        return thirdResponResult;
    }

    public void setThirdResponResult(String thirdResponResult) {
        this.thirdResponResult = thirdResponResult;
    }
}
