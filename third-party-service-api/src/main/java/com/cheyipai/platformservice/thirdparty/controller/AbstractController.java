package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.AccountDb;
import com.cheyipai.platformservice.thirdparty.utils.ApiUtils;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */
public abstract class AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);

    protected ResultMap checkParams(HttpServletRequest request) {
        String[] checkNames = Constants.CHECK_NAMES;
        for (String p : checkNames) {
            if (StringUtils.isBlank(request.getParameter(p))) {
                return ResultMap.getResultMap(BusinessStatusEnum.PARAM_EMPTY);
            }
        }
        return ResultMap.getResultMap(BusinessStatusEnum.SUCCESS);
    }

    protected Map<String, String> populateParamMap(HttpServletRequest request, String... excludes) {
        return ApiUtils.getRequestParamMap(request, excludes);
    }

    protected boolean secureMD5(HttpServletRequest request) {
        //sign 不参与md5加密
        String sign = request.getParameter(Constants.SIGN);
        Map<String, String> map = populateParamMap(request, Constants.SIGN);
        String timeStamp = map.get(Constants.TIME_STAMP);
        String appKey = map.get(Constants.APP_KEY);
        String channel = map.get(Constants.CHANNEL);
        String businessCode = map.get(Constants.BUSINESS_CODE);

        String appSecret;
        AccountDb accountDb = DBUtil.getInstance().getAccountByAppKey(appKey,channel,businessCode);
        if(accountDb != null){
            appSecret = accountDb.getAppSecret();
        }else {
            return false;
        }
        return secureMD5(map, Long.valueOf(timeStamp), appSecret, sign);
    }

    /**
     *
     * @param params
     * @param timeStamp
     * @param appSecret
     * @param sign
     * @return
     */
    protected boolean secureMD5(Map<String, String> params, long timeStamp, String appSecret, String sign) {
        //验证请求时效性
        boolean verified = ApiUtils.isExpiredTimeMinute(timeStamp, Constants.EXPIRED_TIME_MINUTE);
        if (verified) {
            LOG.info("api请求时效性验证失败");
            return false;
        }
        Map<String, String> sortedMap = ApiUtils.sortMapByKey(params);
        String src = ApiUtils.mapToString(sortedMap);
        String sec = appSecret;

        StringBuilder builder = new StringBuilder();
        builder.append(sec).append(src).append(sec);
        LOG.info("src={}",builder.toString());
        String md5Sign = DigestUtils.md5Hex(builder.toString());
        LOG.info("入参sign={}，md5后sign={}", sign, md5Sign);

        if (!md5Sign.equalsIgnoreCase(sign)) {
            LOG.error("入参sign={}，md5后sign={},不一致", sign, md5Sign);
            return false;
        }
        return true;
    }
}
