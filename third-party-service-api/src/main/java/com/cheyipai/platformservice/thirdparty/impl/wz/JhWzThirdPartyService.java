package com.cheyipai.platformservice.thirdparty.impl.wz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.bean.ProcessResult;
import com.cheyipai.platformservice.thirdparty.bean.RequestServiceConfig;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.AccessDb;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.impl.DictManager;
import com.cheyipai.platformservice.thirdparty.impl.WzThirdPartyService;
import com.cheyipai.platformservice.thirdparty.utils.ApiUtils;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import com.cheyipai.platformservice.thirdparty.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/11.
 *
 * http://v.juhe.cn/wz/query?city=SH&hphm=苏L50A11&engineno=123456&key=key
 *
 * 聚合供应商提供的违章服务
 */
public class JhWzThirdPartyService extends WzThirdPartyService {

    private static final Logger LOG = LoggerFactory.getLogger(JhWzThirdPartyService.class);

    public JhWzThirdPartyService(ServiceVendorDb _serviceVendorDb) {
        super(_serviceVendorDb);
    }

    private static final String SUCCESS_CODE = "200";
    /**
     * 	返回数据格式 json或xml或jsonp,默认json
     */
    private static final String DTYPE = "json";
    /**
     * 号牌类型 号牌类型，默认02，暂只支持小型车
     */
    private static final String HPZL = "02";

    private DictManager dictManager = SpringUtils.getBean("dictManager");

    @Override
    public void convertData(String json,ResultMap resultMap) {

        JSONObject jsonObject = JSON.parseObject(json);
        String resultcode = jsonObject.getString("resultcode");
        if(SUCCESS_CODE.equals(resultcode)){
            resultMap.setResultCode(BusinessStatusEnum.SUCCESS.getResultCode());
            resultMap.setStateDescription(BusinessStatusEnum.SUCCESS.getStateDescription());
            resultMap.setData(jsonObject.getJSONObject("result"));
        }else{
            resultMap.setResultCode(BusinessStatusEnum.FAIL.getResultCode());
            resultMap.setStateDescription(BusinessStatusEnum.FAIL.getStateDescription());
            resultMap.setData(jsonObject.getString("reason"));
        }
    }

    /**
     * 业务自定义参数绑定
     *
     * @param requestServiceConfig
     * @param requestConfigMap
     * @return
     */
    @Override
    public List<NameValuePair> buildHttpUriRequestParam(
            RequestServiceConfig requestServiceConfig, Map<String, String> requestConfigMap) {

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("dtype",DTYPE));
        String city = requestConfigMap.get("city");
        city = dictManager.getCityCode(city);
        nameValuePairs.add(new BasicNameValuePair("city",city));
        nameValuePairs.add(new BasicNameValuePair("hphm",requestConfigMap.get("hphm")));//号牌号码
        nameValuePairs.add(new BasicNameValuePair("hpzl",HPZL));
        nameValuePairs.add(new BasicNameValuePair("engineno",requestConfigMap.get("engineno")));//发动机号
        nameValuePairs.add(new BasicNameValuePair("classno",requestConfigMap.get("classno")));//车架号
        nameValuePairs.add(new BasicNameValuePair("key",this.getRequestServiceConfig().getAppKey()));
        return nameValuePairs;
    }

    /**
     * @param requestConfigMap
     * @param ret
     */
    @Override
    public ProcessResult excuteService(Map<String, String> requestConfigMap, ResultMap ret) {
        return super.excuteService(requestConfigMap, ret);
    }

    @Override
    public boolean isExists(String key) {
        String identigyCode = key;
        if(StringUtils.isBlank(identigyCode)){
            return false;
        }
        AccessDb accessDb = DBUtil.getInstance().getAccessByIdentifyCode(identigyCode);
        if(accessDb == null){
            return false;
        }
        Date updateTime = accessDb.getUpdateTime();
        if(updateTime == null ){
            updateTime = accessDb.getCreateTime();
        }
        if(updateTime!=null){
            boolean isExpired = ApiUtils.isExpiredTimeSecond(updateTime, this.getRequestServiceConfig().getCacheTime());
            return (!isExpired);
        }
        return false;
    }

    public DictManager getDictManager() {
        return dictManager;
    }

    public void setDictManager(DictManager dictManager) {
        this.dictManager = dictManager;
    }
}
