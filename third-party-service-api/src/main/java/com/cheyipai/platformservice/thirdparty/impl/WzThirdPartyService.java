package com.cheyipai.platformservice.thirdparty.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.bean.LogModel;
import com.cheyipai.platformservice.thirdparty.bean.ProcessResult;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.AccessDb;
import com.cheyipai.platformservice.thirdparty.entity.AccessDetailDb;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/7.
 */
public abstract class WzThirdPartyService extends AbstractThirdPartyService {

    private static final Logger LOG = LoggerFactory.getLogger(WzThirdPartyService.class);

    public WzThirdPartyService(ServiceVendorDb _serviceVendorDb) {
        super(_serviceVendorDb);
    }


    /**
     *
     * 1.判断数据是否存在
     *     存在，取出记录，设置返回值
     *     不存在，请求第三方接口
     * 2.记录accessDb
     * 3.记录accessDetailDb
     * 4.记录日志
     * @param requestConfigMap
     * @param ret
     */
    @Override
    public ProcessResult excuteService(Map<String, String> requestConfigMap, ResultMap ret) {

        ProcessResult result = ProcessResult.STOP;
        String thirdResponse = null;
        String thirdRequest = null;
        long execTime = 0;
        //1
        String identifyCode = getIdenfyCode(requestConfigMap);

        if (isExists(identifyCode)) {
            assembleResultMap(identifyCode,ret);
        } else {
            try {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                HttpUriRequest httpUriRequest = buildHttpUriRequest(getRequestServiceConfig(),
                        requestConfigMap);
                CustomHttpClient.HttpResult httpResult = HttpClientFactory.customHttpClient().
                        sendRequestGetEntityBytes(httpUriRequest);
                thirdRequest = buildThirdParam(requestConfigMap);
                thirdResponse = httpResult.getContent();
                stopWatch.stop();
                execTime = stopWatch.getTime();

                convertData(thirdResponse,ret);

            } catch (Exception e) {
                LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
                return ProcessResult.CONTINUE;
            }
        }
        //2
        AccessDb accessDb = doSaveAccessDb(requestConfigMap,ret);
        //3
        AccessDetailDb detailDb = saveAccessDetailDb(requestConfigMap, ret,thirdRequest, thirdResponse, accessDb);
        //4
        doLog(execTime, detailDb);
        return result;
    }

    private void doLog(long execTime, AccessDetailDb detailDb) {
        LogModel model = new LogModel();
        model.setParam(detailDb.getRequestParam());
        model.setTakeTime(execTime);
        model.setServiceType(this.getRequestServiceConfig().getServiceType());
        model.setResult(detailDb.getResponseResult());
        model.setThirdParams(detailDb.getThirdRequestParam());
        model.setThirdResponse(detailDb.getThirdResponseResult());
        model.setThirdUri(this.getRequestServiceConfig().getRequestUrl());
        LOG.info(model.toString());
    }

    private AccessDetailDb saveAccessDetailDb(Map<String, String> requestConfigMap, ResultMap ret, String thirdParamJson,String thirdResponse, AccessDb accessDb) {
        Map<String,String> sortedMap;
        sortedMap = ApiUtils.sortMapByKey(requestConfigMap);
        String reqParamJson = JSON.toJSONString(sortedMap);
        return doSaveAccessDetailDb(reqParamJson,thirdParamJson,accessDb.getId(), thirdResponse, ret);
    }

    private String buildThirdParam(Map<String,String> requestMap){
        List<NameValuePair> thirdParamList = buildHttpUriRequestParam(this.getRequestServiceConfig(),requestMap);
        Map<String,String> thirdParamMap = new HashMap<>();
        for(NameValuePair pair : thirdParamList ){
            thirdParamMap.put(pair.getName(),pair.getValue());
        }
        return JSON.toJSONString(thirdParamMap);
    }
    @Override
    public String toString() {
        return this.getRequestServiceConfig().toString();
    }
    private AccessDb doSaveAccessDb(Map<String, String> requestConfigMap,ResultMap resultMap){
        AccessDb accessDb = new AccessDb();
        accessDb.setAppKey(requestConfigMap.get(Constants.APP_KEY));
        accessDb.setVendorCode(this.getServiceVendorDb().getCode());
        accessDb.setBusinessCode(requestConfigMap.get(Constants.BUSINESS_CODE));
        accessDb.setChannel(requestConfigMap.get(Constants.CHANNEL));
        accessDb.setCreateTime(new Date());
        accessDb.setIdentifyCode(buildIdentifyCode(requestConfigMap));
        if(resultMap.getResultCode().equals(BusinessStatusEnum.SUCCESS.getResultCode())){
            accessDb.setStatus(1);// 1有效 0 无效
        }else{
            accessDb.setStatus(0);
        }
        DBUtil.getInstance().addAccess(accessDb);
        return accessDb;
    }

    protected String buildIdentifyCode(Map<String, String> requestConfigMap){
        String identify;
        Map<String, String> m = requestConfigMap;
        String[] excludes = {Constants.APP_KEY,Constants.BUSINESS_CODE,Constants.CHANNEL,Constants.SIGN,Constants.TIME_STAMP};
        m = ApiUtils.getExcludedMap(m,excludes);
        m = ApiUtils.sortMapByKey(m);
        identify = ApiUtils.mapToString(m,Constants.DELIMITER);
        return identify;
    }
    private AccessDetailDb doSaveAccessDetailDb(String reqParamJson,String thirdParamJson,long accessId,String thirdResponseResult,ResultMap ret){
        AccessDetailDb detailDb = new AccessDetailDb();
        detailDb.setAccessId(accessId);
        detailDb.setThirdRequestParam(thirdParamJson);
        detailDb.setThirdResponseResult(thirdResponseResult);
        detailDb.setCreateTime(new Date());
        Object o = ret.getData();
        if(o instanceof  String){
            detailDb.setResponseResult((String)o);
        }
        if(o instanceof JSONObject){
            detailDb.setResponseResult(((JSONObject)o).toJSONString());
        }
        detailDb.setRequestParam(reqParamJson);
        DBUtil.getInstance().addAccessDetail(detailDb);
        return detailDb;
    }
    private String getIdenfyCode(Map<String,String> requestConfigMap){
        String idCode = requestConfigMap.get(Constants.REQ_PARAM_IDENTIFY_CODE);
        if(StringUtils.isBlank(idCode)){
            idCode = buildIdentifyCode(requestConfigMap);
        }
        return idCode;
    }

    private void assembleResultMap(String identifyCode ,ResultMap resultMap){
        resultMap.setResultCode(BusinessStatusEnum.SUCCESS.getResultCode());
        resultMap.setStateDescription(BusinessStatusEnum.SUCCESS.getStateDescription());
        AccessDb accessDb = DBUtil.getInstance().getAccessByIdentifyCode(identifyCode);

        if(accessDb!=null){
            AccessDetailDb accessDetailDb = DBUtil.getInstance().getAccessDetailByAccessId(accessDb.getId());
            if(accessDetailDb!=null){
                String responseResult = accessDetailDb.getResponseResult();
                if(StringUtils.isNotBlank(responseResult)){
                    resultMap.setData(responseResult);
                }
            }
        }

    }

}
