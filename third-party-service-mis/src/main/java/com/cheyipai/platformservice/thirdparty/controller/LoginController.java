package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.entity.User;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
@RequestMapping(ApiUrls.LOGIN)
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping( value="/tologin")
    public String toLogin(HttpServletRequest request){
        return "login";
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request,String username,String password,String captcha){

        if(StringUtils.isBlank(username) || StringUtils.isBlank(username) || StringUtils.isBlank(captcha)){
            return ResultMap.getResultMap(BusinessStatusEnum.PARAM_EMPTY);
        }
        if(username.equals("admin")){
            throw new RuntimeException("admin error");
        }
        HttpSession session = request.getSession();
        String sessionCapt = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!sessionCapt.equals(captcha)){
            return ResultMap.getResultMap(BusinessStatusEnum.CAPTCHA_ERROR);
        }
        LOG.info(username+"_"+password+"_"+captcha);
        DataAccessException dataAccessException;
        SQLException sqlException;
        session.setAttribute("loginUser",new User());
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        return ResultMap.getResultMap(BusinessStatusEnum.SUCCESS);
    }
}
