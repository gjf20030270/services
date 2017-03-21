package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.entity.AccessDb;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by gongjunfeng on 2017/3/9.
 */
public class AccessMapperTest extends BaseBeanTest {

    private static Logger logger = LoggerFactory.getLogger(AccessMapperTest.class);

    @Test
    public void testGetAccesses() {
        DBUtil.getInstance().getAccesses();
        List<AccessDb> accessList = DBUtil.getInstance().getAccesses();
        for (AccessDb a : accessList) {
            System.out.printf("id=%s,channel=%s,appKey=%s,vendorCode=%s,businessCode=%s,\n creatTime=%s" +
                            ",callbackTime=%s,identifyCode=%s,thirdIdentifyId=%s,status=%s .\n",
                    a.getId(), a.getChannel(), a.getAppKey(), a.getVendorCode(),
                    a.getBusinessCode(), a.getCreateTime(), a.getCallbackTime(),
                    a.getIdentifyCode(), a.getThirdIdentifyId(), a.getStatus());
        }
        System.out.println("accessList=" + accessList.size());

    }

    @Test
    public void testInsertAccount() {

        AccessDb accessDb = new AccessDb();
        accessDb.setAppKey("test1");
        accessDb.setCreateTime(new Date());
        accessDb.setBusinessCode("code1");
        accessDb.setCallbackTime(new Date());
        accessDb.setChannel("android");
        accessDb.setVendorCode("jh");
        accessDb.setIdentifyCode("2212");
        accessDb.setThirdIdentifyId("third1334");
        accessDb.setStatus(1);
        DBUtil.getInstance().addAccess(accessDb);
        Assert.assertNotEquals("id为0", 0, accessDb.getId());

        System.out.println("插入成功");

    }

}
