package com.cheyipai.platformservice.thirdparty.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.bean.JuheCityResult;
import com.cheyipai.platformservice.thirdparty.entity.DictDb;
import com.cheyipai.platformservice.thirdparty.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gongjunfeng on 2017/3/20.
 */
public class DictManager {

    private final static Logger LOG = LoggerFactory.getLogger(DictManager.class);
    /**
     * http://v.juhe.cn/wz/citys?key=fcded50227e14b8192f21f14b8c7e6f3
     */
    private static final String JUHECITYS_URI = "juhecitysUri";
    private static final String JUHE_KEY = "juheKey";
    private static Map<String,JuheCityResult.JuheCity> juheCitys = new ConcurrentHashMap<>();

    static{
        try {
            loadCitys();
        } catch (Exception e) {
            LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
        }
    }

    public static String getCityCode(String cityName){
        if(StringUtils.isBlank(cityName)){
            return "";
        }
        JuheCityResult.JuheCity city = juheCitys.get(cityName);
        if(city != null){
            return city.getCityCode() == null ? "":city.getCityCode();
        }
        return "";
    }
    public static void loadCitys(){
        DictDb dict = selectWzCity();
        if(dict!=null){
            Date updateTime = dict.getUpdateTime();
            if (updateTime == null) {
                updateTime = dict.getCreateTime();
            }
            if(updateTime!=null){
                boolean isExpired = ApiUtils.isExpiredTimeSecond(updateTime.getTime(),24 * 60 * 60);
                if(!isExpired){
                    return;
                }
            }
        }
        try {
            initCitys();
        } catch (Exception e) {
            LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
        }
    }
    private static void initCitys() throws Exception {
        String juhecitysUri = getJuheCitysUri();
        CustomHttpClient client = HttpClientFactory.customHttpClient();
        HttpUriRequest request = client.buildHttpUriRequest(juhecitysUri, "GET", null, 1000);
        String content = client.sendRequestGetEntityBytes(request).getContent();
        parseJuheCitys(content);
        saveOrUpdate(content);
    }

    private static String getJuheCitysUri() {
        String juhecitysUri = PropertiesUtil.getString(JUHECITYS_URI);
        String key = PropertiesUtil.getString(JUHE_KEY);
        juhecitysUri = juhecitysUri.trim() + "?key="+key;
        return juhecitysUri;
    }

    private static int saveOrUpdate(String content){
        DictDb dict = selectWzCity();
        if(dict==null){
            return saveWzCity(content);
        }else{
            dict.setUpdateTime(new Date());
            dict.setData(content);
            return updateWzCity(dict);
        }
    }
    private static int updateWzCity(DictDb dict){
        return DBUtil.getInstance().updateDict(dict);
    }
    private static DictDb selectWzCity(){
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("serviceType", Constants.THIRD_PARTY_SERVICE_TYPE_WZ);
        queryParam.put("code",Constants.SERVICE_VENDOR_JUHE);
        queryParam.put("businessType",Constants.JUHE_BUSINESS_TYPE_CITY);
        List<DictDb> dictDbs = DBUtil.getInstance().getDicts(queryParam);
        DictDb dict = null;
        if(dictDbs.size()>0){
            dict = dictDbs.get(0);
        }
        return dict;
    }
    private static int saveWzCity(String content){
        DictDb dict = new DictDb();
        dict.setServiceType( Constants.THIRD_PARTY_SERVICE_TYPE_WZ);
        dict.setBusinessType( Constants.JUHE_BUSINESS_TYPE_CITY);
        dict.setCode(Constants.SERVICE_VENDOR_JUHE);
        dict.setCreateTime(new Date());
        dict.setData(content);
        dict.setStatus(1);
        dict.setRemark("聚合违章城市列表");
        return DBUtil.getInstance().addDict(dict);
    }

    private static void parseJuheCitys(String content){
        if(StringUtils.isBlank(content)){
            return;
        }
        JSONObject jsonObject = JSON.parseObject(content);
        String resultJson = jsonObject.getJSONObject("result").toJSONString();
        Map<String,JuheCityResult.JuheProvince> provinceMap = JSON.parseObject(resultJson,new TypeReference<Map<String,JuheCityResult.JuheProvince>>(){});
        Set<Map.Entry<String,JuheCityResult.JuheProvince>> entrySet =provinceMap.entrySet();
        for(Map.Entry<String,JuheCityResult.JuheProvince> entry : entrySet){
            JuheCityResult.JuheProvince province = entry.getValue();
            List<JuheCityResult.JuheCity> citys = province.getCitys();
            for(JuheCityResult.JuheCity city : citys){
                String cityName = city.getCityName();
                juheCitys.put(cityName,city);
            }
        }
    }
}
