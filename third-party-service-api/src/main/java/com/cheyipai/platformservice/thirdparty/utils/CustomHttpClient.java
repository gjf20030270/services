package com.cheyipai.platformservice.thirdparty.utils;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.CodingErrorAction;
import java.util.List;

public class CustomHttpClient {

    /**
     * 自定义HTT状态-无状态
     */
    public static final int STATUS_CODE_NULL = 601;
    public static final int OK = 200;
    /**
     * 自定义HTTP状态-Socket超时
     */
    public static final int STATUS_SOCKET_TIMEOUT = 604;
    /**
     * 自定义HTTP状态-连接超时
     */
    public static final int STATUS_CONNECT_TIMEOUT = 600;
    /**
     * 自定义HTT状态-其它错误
     */
    public static final int STATUS_CODE_OTHER = 603;
    CloseableHttpClient httpClient;

    public CustomHttpClient() {
        Registry<ConnectionSocketFactory> socketFactory = RegistryBuilder
                .<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register(
                        "https",
                        new SSLConnectionSocketFactory(SSLContexts
                                .createSystemDefault())).build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                socketFactory);

        SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true)
                .setSoKeepAlive(true).build();
        connManager.setDefaultSocketConfig(socketConfig);

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Consts.UTF_8)
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE).build();
        connManager.setDefaultConnectionConfig(connectionConfig);

        connManager.setMaxTotal(65535);
        connManager.setDefaultMaxPerRoute(65535);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000).setSocketTimeout(3000)
                .setConnectionRequestTimeout(5000)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        httpClient = HttpClients.custom().setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig).build();

        String info = new StringBuilder().append("socketFactory:")
                .append(socketFactory.toString()).append("socketConfig:")
                .append(socketConfig.toString()).append('\t')
                .append("connectionConfig:")
                .append(connectionConfig.toString()).append('\t')
                .append("requestConfig:").append(requestConfig.toString())
                .toString();
//        CommonLogger.getLogger().info(
//                String.format("httpclient inited %s", info));
    }

    public HttpResult sendRequestGetEntityBytes(HttpUriRequest request)
            throws ClientProtocolException, IOException, NullPointerException {
        HttpEntity entity = null;
        HttpResult result = new HttpResult();
        try {

            HttpResponse response = httpClient.execute(request);
            StatusLine status = response.getStatusLine();
            entity = response.getEntity();
            result.setHeaders(response.getAllHeaders());
            result.setStatusCode(status != null ? status.getStatusCode() : STATUS_CODE_NULL);
            if (status != null && status.getStatusCode() == OK) {
                result.setContent(EntityUtils.toString(entity, "utf-8"));
            } else {
                result.setContent("");
            }
        } catch (SocketTimeoutException e) {
            result.setStatusCode(STATUS_SOCKET_TIMEOUT);
//            logger.error(
//                    "HttpExecute SocketTimeoutException " + request.getURI(), e);
        } catch (ConnectTimeoutException e) {
            result.setStatusCode(STATUS_CONNECT_TIMEOUT);
//            logger.error(
//                    "HttpExecute ConnectTimeoutException " + request.getURI(),
//                    e);
        } catch (Exception e) {
            result.setStatusCode(STATUS_CODE_OTHER);
//            logger.error("HttpExecute exception " + request.getURI(), e);
        } finally {
            if (request != null) {
                request.abort();
            }
        }
        return result;
    }
    public HttpUriRequest buildHttpUriRequest(String httpUri,String httpMethod,List<NameValuePair> params,int timeOut)
            throws URISyntaxException, IllegalAccessException {

        URI uri = null;
        String integratedUrl = ThirdPartyServiceUtil.checkRequstUrl(httpUri);

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
                .setConnectTimeout(timeOut)
                .setSocketTimeout(0)
                .setConnectionRequestTimeout(
                        timeOut)
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
    public class HttpResult {
        private Header[] headers;
        private String content;
        private int statusCode = 200;

        public Header[] getHeaders() {
            return headers;
        }

        public void setHeaders(Header[] headers) {
            this.headers = headers;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }
}
