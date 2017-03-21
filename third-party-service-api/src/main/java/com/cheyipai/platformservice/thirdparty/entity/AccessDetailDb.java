package com.cheyipai.platformservice.thirdparty.entity;

import java.util.Date;

/**
 * Created by gongjunfeng on 2017/3/10.
 */
public class AccessDetailDb {
    private long id;
    private long accessId;
    private String requestParam;
    private String thirdRequestParam;
    private String responseResult;
    private String thirdResponseResult;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessId() {
        return accessId;
    }

    public void setAccessId(long accessId) {
        this.accessId = accessId;
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

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public String getThirdResponseResult() {
        return thirdResponseResult;
    }

    public void setThirdResponseResult(String thirdResponseResult) {
        this.thirdResponseResult = thirdResponseResult;
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
}
