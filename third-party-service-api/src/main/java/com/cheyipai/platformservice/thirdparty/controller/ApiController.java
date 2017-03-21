package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceManager;
import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
public class ApiController extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping(value = "/api/v1", method = RequestMethod.GET)
    @ResponseBody
    public ResultMap execute(HttpServletRequest request) {

        try{
            ResultMap result = checkParams(request);
            if(!BusinessStatusEnum.SUCCESS.getResultCode().equals(result.get("resCode"))){
                return result;
            }
            boolean isSecured = secureMD5(request);
            if (!isSecured) {
                return ResultMap.getResultMap(BusinessStatusEnum.SECURE_ERROR);
            }
            Map<String, String> map = populateParamMap(request);
            return ThirdPartyServiceManager.getInstance().getThirdPartyServiceResult(map);
        }catch(Exception e){
            LOG.error(ExceptionUtil.getExceptionTraceInfo(e));
            return ResultMap.getResultMap(BusinessStatusEnum.FAIL);
        }

    }
}
