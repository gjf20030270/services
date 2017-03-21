package com.cheyipai.platformservice.thirdparty.bean;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/12.
 */
public class Chain {

    private List<ThirdPartyService> chainElements = new ArrayList<>();

    public List<ThirdPartyService> getChainElements() {
        return chainElements;
    }

    public void setChainElements(List<ThirdPartyService> chainElements) {
        this.chainElements = chainElements;
    }


    public void addThirdPartyService(ThirdPartyService thirdPartyService) {
        this.chainElements.add(thirdPartyService);
    }


    public void excuteService(Map<String, String> requestConfigMap , ResultMap ret) {

        if (null == requestConfigMap || requestConfigMap.size() == 0) {
            return;
        }

        for (ThirdPartyService thirdPartyService: chainElements) {

            ProcessResult processResult = thirdPartyService.excuteService(requestConfigMap, ret);

            if (processResult == ProcessResult.STOP) {
                break;
            }
        }

    }

}
