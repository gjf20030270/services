package com.cheyipai.platformservice.thirdparty.dao.mapper;


import com.cheyipai.platformservice.thirdparty.bean.Account;

import java.util.List;

/**
 * Created by miqi on 2017/3/7.
 */
public interface AccountMapper {
    int insertAccount(Account account);
    int updateAccount(Account account);
    List<Account> selectAccount();
    int deleteAccount(String id);
}
