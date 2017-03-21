package com.cheyipai.platformservice.thirdparty;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceException extends RuntimeException{

    public ThirdPartyServiceException(String message) {
        super();
    }

    public ThirdPartyServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
