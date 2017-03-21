package com.cheyipai.platformservice.thirdparty.utils;

public class HttpClientFactory {

    static CustomHttpClient customHttpClientInstance;

    static {
        customHttpClientInstance = new CustomHttpClient();
    }

    public static CustomHttpClient customHttpClient() {
        return customHttpClientInstance;
    }
}