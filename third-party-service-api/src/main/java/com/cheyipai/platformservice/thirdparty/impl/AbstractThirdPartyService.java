package com.cheyipai.platformservice.thirdparty.impl;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.bean.RequestServiceConfig;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.utils.ThirdPartyServiceUtil;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/7.
 */
public abstract class AbstractThirdPartyService implements ThirdPartyService {

    private static Logger LOG = LoggerFactory.getLogger(AbstractThirdPartyService.class);

    private ServiceVendorDb serviceVendorDb;

    private RequestServiceConfig requestServiceConfig;

    private String serviceType;

    /*
     * 1.设置数据库对象
     * 2.构件请求配置对象
     *
     * @param _serviceVendorDb
     */
    public AbstractThirdPartyService(ServiceVendorDb _serviceVendorDb) {
        // 1.
        this.serviceVendorDb = _serviceVendorDb;
        this.serviceType = _serviceVendorDb.getServiceType();
        try {
            // 2.
            buildRequestServiceConfig(_serviceVendorDb);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("解析服务提供商服务规则失败,原因:" + e.getMessage() + " " + _serviceVendorDb);
        }

    }

    public abstract void convertData(String json, ResultMap resultMap);

    @Override
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public abstract List<NameValuePair> buildHttpUriRequestParam(
            RequestServiceConfig requestServiceConfig, Map<String, String> requestConfigMap);

    public HttpUriRequest buildHttpUriRequest(RequestServiceConfig requestServiceConfig,
                                              Map<String, String> requestConfigMap)
            throws URISyntaxException, IllegalAccessException {
        String httpMethod = requestServiceConfig.getRequestMethod();

        List<NameValuePair> params = buildHttpUriRequestParam(requestServiceConfig, requestConfigMap);

        URI uri = null;
        String integratedUrl = ThirdPartyServiceUtil.checkRequstUrl(requestServiceConfig.getRequestUrl());

        if (httpMethod.equals("POST")) {
            uri = new URI(integratedUrl);
        } else {
            if (params != null && !params.isEmpty()) {
                uri = new URI(String.format("%s?%s", integratedUrl,
                        URLEncodedUtils.format(params, Consts.UTF_8)));
            } else {
                uri = new URI(integratedUrl);
            }
        }

        HttpRequestBase requestBase = getHttpRequest(uri, httpMethod, params);

        RequestConfig config = RequestConfig
                .custom()
                .setConnectTimeout(requestServiceConfig.getRequestTimeOut())
                .setSocketTimeout(0)
                .setConnectionRequestTimeout(
                        requestServiceConfig.getRequestTimeOut() + 1000)
                .build();
        requestBase.setConfig(config);

        return requestBase;

    }

    public HttpRequestBase getHttpRequest(URI uri, String httpMethod,
                                          List<NameValuePair> params) {
        HttpRequestBase requestBase = null;
        switch (httpMethod) {
            case "GET":
                HttpGet httpGet = new HttpGet(uri);
                requestBase = httpGet;
                break;
            case "POST":
                HttpPost httpPost = new HttpPost(uri);
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,
                        Consts.UTF_8);
                httpPost.setEntity(entity);
                requestBase = httpPost;
                break;
            case "PUT":
                HttpPut httpPut = new HttpPut(uri);
                requestBase = httpPut;
                break;
            case "OPTIONS":
                HttpOptions httpOptions = new HttpOptions(uri);
                requestBase = httpOptions;
                break;
            case "DELETE":
                HttpDelete httpDelete = new HttpDelete(uri);
                requestBase = httpDelete;
                break;
            case "TRACE":
                HttpTrace httpTrace = new HttpTrace(uri);
                requestBase = httpTrace;
                break;
            case "HEAD":
                HttpHead httpHead = new HttpHead(uri);
                requestBase = httpHead;
                break;
        }
        return requestBase;
    }

    @Override
    public boolean isExists(String key) {
        return false;
    }


    public ServiceVendorDb getServiceVendorDb() {
        return serviceVendorDb;
    }


    @Override
    public RequestServiceConfig getRequestServiceConfig() {
        return this.requestServiceConfig;
    }

    public RequestServiceConfig buildRequestServiceConfig(ServiceVendorDb serviceVendorDb) {
        if (requestServiceConfig == null) {
            requestServiceConfig = new RequestServiceConfig();
        }

        if (serviceVendorDb != null) {
            requestServiceConfig.setRequestUrl(serviceVendorDb.getRequestUrl());
            requestServiceConfig.setServiceType(serviceVendorDb.getServiceType());
            requestServiceConfig.setVendorCode(serviceVendorDb.getCode());
            requestServiceConfig.setLevel(serviceVendorDb.getLevel());
            requestServiceConfig.setAppKey(serviceVendorDb.getAppKey());
            requestServiceConfig.setRequestMethod(serviceVendorDb.getRequestMethod());
            requestServiceConfig.setRequestTimeOut(Integer.valueOf(serviceVendorDb.getRequestTimeOut()));
            requestServiceConfig.setRequestMethod(serviceVendorDb.getRequestMethod());
            requestServiceConfig.setVendorName(serviceVendorDb.getName());
        }

        return requestServiceConfig;
    }

}
