package test;

import com.cheyipai.platformservice.thirdparty.bean.Account;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.service.AccountService;
import com.cheyipai.platformservice.thirdparty.utils.MD5Util;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by miqi on 2017/3/17.
 */
public class AccountServiceTest extends BaseBeanTest{
    @Resource
    private AccountService accountService;
    @Test
    public void testInsertAccount() {
        String appKey = UUID.randomUUID().toString();
        appKey = appKey.substring(0, 8) + appKey.substring(9, 13) + appKey.substring(14, 18) + appKey.substring(19, 23) + appKey.substring(24);
        String appSecret = MD5Util.md5Hex("key" + appKey);

        Account account = new Account();
        account.setAppSecret(appSecret);
        account.setAppKey(appKey);
        account.setBusiCode("busiCode1");
        account.setChannel("PC");
        account.setDescription("账户授权");
        account.setName("车易拍官网");
        account.setState(1);
        accountService.insertAccount(account);
        Long id = account.getId()==null ?-1L:account.getId().longValue();
        Assert.assertNotEquals("id为-1", -1, account.getId().longValue());
        System.out.println("插入成功");
    }
    @Test
    public void testDeleteAccount() {
        String id = "2";
        ResultMap r = accountService.deleteAccount(id);
        if ("1".equals(r.get("resCode")))
            System.out.println("插入成功");
    }
    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        Integer id = 2;
        account.setId(id);
        account.setBusiCode("busiCode2");
        account.setChannel("IOS");
        account.setDescription("账户授权");
        account.setName("车易拍官网");
        ResultMap r = accountService.updateAccount(account);
        if ("1".equals(r.get("resCode")))
            System.out.println("插入成功");
    }
    @Test
    public void testSelectAccount() {
        List<Account> accountList = accountService.selectAccount();
        for (Account a : accountList) {
            System.out.printf("id=%s,appKey=%s,appSecret=%s,name=%s,description=%s,\n state=%s" +
                            ",createTime=%s,updateTime=%s,busiCode=%s,channel=%s .\n",
                    a.getId(), a.getAppKey(), a.getAppSecret(), a.getName(),
                    a.getDescription(), a.getState(), a.getCreateTime(),
                    a.getUpdateTime(), a.getBusiCode(), a.getChannel());
        }
        System.out.println("accountList=" + accountList.size());
    }

}
