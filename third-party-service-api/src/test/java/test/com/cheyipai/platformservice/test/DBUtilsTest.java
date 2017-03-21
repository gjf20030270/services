package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.entity.AccountDb;
import com.cheyipai.platformservice.thirdparty.entity.DictDb;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongjunfeng on 2017/3/16.
 */
public class DBUtilsTest extends BaseBeanTest {
    @Test
    public void testGetAccountByAppKey() {
        String appKey = "2";
        String channel = "pc";
        String businessCode = "query";
        AccountDb accountDb = DBUtil.getInstance().getAccountByAppKey(appKey,channel,businessCode);
        Assert.notNull(accountDb);
    }

    @Test
    public void testGetDictById(){
        long id = 1;
        DictDb dict = DBUtil.getInstance().getDictById(id);
        System.out.println(dict);
        Assert.notNull(dict);
    }
    @Test
    public void testGetDicts(){
        Map<String,String> params = new HashMap<>();
        params.put("type","wz_city");
        params.put("code","天津");
        params.put("value","TJ");
        List<DictDb> list = DBUtil.getInstance().getDicts(params);
        for(DictDb dict : list){
            System.out.println(dict.getServiceType());
        }
        Assert.notEmpty(list);
    }

}
