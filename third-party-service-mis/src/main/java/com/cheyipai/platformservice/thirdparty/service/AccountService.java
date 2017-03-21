package com.cheyipai.platformservice.thirdparty.service;

import com.cheyipai.platformservice.thirdparty.bean.Account;
import com.cheyipai.platformservice.thirdparty.commons.constants.BusinessStatusEnum;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.mapper.AccountMapper;
import com.cheyipai.platformservice.thirdparty.utils.json.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
* Created by miqi on 2017/3/7.
*/
@Service("accountServic")
public class AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Resource
    private AccountMapper accountMapper;

    public ResultMap insertAccount(Account account){
        String appKey = UUID.randomUUID().toString();
        appKey = appKey.substring(0, 8) + appKey.substring(9, 13) + appKey.substring(14, 18) + appKey.substring(19, 23) + appKey.substring(24);
        String appSecret = MD5Util.md5Hex("key" + appKey);
        account.setAppKey(appKey);
        account.setAppSecret(appSecret);
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
            int i = accountMapper.insertAccount(account);
            if (i>0)
                rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        return rm;
    }

    public ResultMap updateAccount(Account account){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
            int i = accountMapper.updateAccount(account);
            if (i>0)
                rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        return rm;
    }

    public List<Account> selectAccount(){
        List<Account> accounts= accountMapper.selectAccount();
        return accounts;
    }

    public ResultMap deleteAccount(String id){
        ResultMap rm = new ResultMap(BusinessStatusEnum.FAIL);
        int i = accountMapper.deleteAccount(id);
        if (i>0)
            rm = new ResultMap(BusinessStatusEnum.SUCCESS);
        return rm;
    }
}
