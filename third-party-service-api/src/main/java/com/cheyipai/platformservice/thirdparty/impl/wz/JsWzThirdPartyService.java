package com.cheyipai.platformservice.thirdparty.impl.wz;

import com.cheyipai.platformservice.thirdparty.bean.ProcessResult;
import com.cheyipai.platformservice.thirdparty.bean.RequestServiceConfig;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.impl.WzThirdPartyService;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/11.
 *
 * 极速供应商提供的违章服务
 */
public class JsWzThirdPartyService extends WzThirdPartyService{
    public JsWzThirdPartyService(ServiceVendorDb _serviceVendorDb) {
        super(_serviceVendorDb);
    }

    @Override
    public void convertData(String json,ResultMap resultMap) {

    }


    @Override
    public List<NameValuePair> buildHttpUriRequestParam(RequestServiceConfig requestServiceConfig, Map<String, String> requestConfigMap) {
        return null;
    }

    @Override
    public ProcessResult excuteService(Map<String, String> requestConfigMap, ResultMap ret) {
        return super.excuteService(requestConfigMap, ret);
    }
}
