package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.bean.Account;
import com.cheyipai.platformservice.thirdparty.commons.constants.ApiUrls;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.service.AccountService;
import com.cheyipai.platformservice.thirdparty.utils.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by miqi on 2017/3/7.
 */
@Controller
@RequestMapping(ApiUrls.ACCOUNT)
public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/selectAccount")
    public String selectVendor(){
        return "account";
    }
    @ResponseBody
    @RequestMapping(value = "/accountInfo.json")
    public Object accountInfoJson(){
        List<Account> account = accountService.selectAccount();
        return account;
    }
    @ResponseBody
    @RequestMapping(value = "/optAccount",method = {RequestMethod.GET, RequestMethod.POST})
    public String insertVendor(Account account,HttpServletRequest request){
        JsonMapper jm = JsonMapper.buildNormalBinder();
        ResultMap rm = null;
        String id = account.getId().toString();
        if("-1".equals(id)){
            rm = accountService.insertAccount(account);
        }else{
            rm = accountService.updateAccount(account);
        }
        return jm.toJson(rm);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteAccount",method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteAccount(@RequestParam String id){
        JsonMapper jm = JsonMapper.buildNormalBinder();
        ResultMap rm = accountService.deleteAccount(id);
        return jm.toJson(rm);
    }
}
