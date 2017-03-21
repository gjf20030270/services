package com.cheyipai.platformservice.thirdparty.entity;

import java.util.Date;

/**
 * Created by jiamingku on 2017/3/7.
 */
public class ServiceVendorDb {
    private long id;
    private String code;
    private String name;
    private String serviceType;
    private String reqparamMap;
    private String requestUrl;
    private String requestTimeOut;
    private String requestMethod;
    private String callbackUrl;
    private String notifyType;
    private int level;
    private Date serviceStartTime;
    private Date serviceStopTime;
    private Date createTime;
    private Date updateTime;
    private String companyPhone;
    private String contactsPhone;
    private String contactsName;
    private String account;
    private String settlementType;
    private String chargeBasic;
    private String remark;
    private int status;
    private String appKey;
    private String appSecret;
    private String cacheTime;

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    public String getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(String cacheTime) {
        this.cacheTime = cacheTime;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getRequestTimeOut() {
        return requestTimeOut;
    }

    public void setRequestTimeOut(String requestTimeOut) {
        this.requestTimeOut = requestTimeOut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getReqparamMap() {
        return reqparamMap;
    }

    public void setReqparamMap(String reqparamMap) {
        this.reqparamMap = reqparamMap;
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Date serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Date getServiceStopTime() {
        return serviceStopTime;
    }

    public void setServiceStopTime(Date serviceStopTime) {
        this.serviceStopTime = serviceStopTime;
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

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }


    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public String getChargeBasic() {
        return chargeBasic;
    }

    public void setChargeBasic(String chargeBasic) {
        this.chargeBasic = chargeBasic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceVendorDb{");
        sb.append("account='").append(account).append('\'');
        sb.append(", id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", serviceType='").append(serviceType).append('\'');
        sb.append(", reqparamMap='").append(reqparamMap).append('\'');
        sb.append(", requestUrl='").append(requestUrl).append('\'');
        sb.append(", requestTimeOut='").append(requestTimeOut).append('\'');
        sb.append(", requestMethod='").append(requestMethod).append('\'');
        sb.append(", callbackUrl='").append(callbackUrl).append('\'');
        sb.append(", notifyType='").append(notifyType).append('\'');
        sb.append(", level=").append(level);
        sb.append(", serviceStartTime=").append(serviceStartTime);
        sb.append(", serviceStopTime=").append(serviceStopTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", companyPhone='").append(companyPhone).append('\'');
        sb.append(", constactPhone='").append(contactsPhone).append('\'');
        sb.append(", contactsName='").append(contactsName).append('\'');
        sb.append(", settlementType='").append(settlementType).append('\'');
        sb.append(", chargeBasic='").append(chargeBasic).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append(", status=").append(status);
        sb.append(", appKey='").append(appKey).append('\'');
        sb.append(", appSecret='").append(appSecret).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
