package com.cheyipai.platformservice.thirdparty;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by jiamingku on 2017/3/6.
 */
public class ThirdPartyServiceException extends RuntimeException {

    public ThirdPartyServiceException(String message) {
        super();
    }

    public ThirdPartyServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(DigestUtils.md5Hex("222"));
    }
}
