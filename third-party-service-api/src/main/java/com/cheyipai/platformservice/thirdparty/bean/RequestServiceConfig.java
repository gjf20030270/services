package com.cheyipai.platformservice.thirdparty.bean;


/**
 * Created by jiamingku on 2017/3/8.
 */
public class RequestServiceConfig {

    private String requestUrl;
    private String requestMethod;
    private String vendorName;

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    private int requestTimeOut;
    private int level;
    private String appKey;

    private String vendorCode;
    private String serviceType;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public int getRequestTimeOut() {
        return requestTimeOut;
    }

    public void setRequestTimeOut(int requestTimeOut) {
        this.requestTimeOut = requestTimeOut;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RequestServiceConfig{");
        sb.append("appKey='").append(appKey).append('\'');
        sb.append(", requestUrl='").append(requestUrl).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", vendorName='").append(vendorName).append('\'');
        sb.append(", requestTimeOut=").append(requestTimeOut);
        sb.append(", level=").append(level);
        sb.append(", vendorCode='").append(vendorCode).append('\'');
        sb.append(", serviceType='").append(serviceType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
