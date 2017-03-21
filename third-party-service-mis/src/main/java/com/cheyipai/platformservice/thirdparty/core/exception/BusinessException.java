package com.cheyipai.platformservice.thirdparty.core.exception;

/**
 * Created by Administrator on 2017/2/22.
 */
public class BusinessException extends RuntimeException {


    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BusinessException(Integer status, String arg0, Throwable arg1) {
        super(arg0, arg1);
        this.status = status;
    }

    public BusinessException(Integer status, String arg0) {
        super(arg0);
        this.status = status;
    }

    public BusinessException(Integer status, Throwable arg0) {
        super(arg0);
        this.status = status;
    }
}