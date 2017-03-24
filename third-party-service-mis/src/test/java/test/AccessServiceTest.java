package test;

import com.cheyipai.platformservice.thirdparty.bean.Access;
import com.cheyipai.platformservice.thirdparty.service.AccessService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by miqi on 2017/3/20.
 */
public class AccessServiceTest extends BaseBeanTest{

    @Resource
    private AccessService accessService;

    @Test
    public void testSelectAccess() {
        List<Access> accessList = accessService.selectAccess(new Access());
        for (Access a : accessList) {
            System.out.printf("id=%s,channel=%s,appKey=%s,busiCode=%s \n" +
                            ",identifyCode=%s,thirdIdentifyId=%s,createTime=%s,updateTime=%s \n"+
                            ",callbackTime=%s,status=%s \n" +
                            ",requestParam=%s \n" +
                            ",thirdRequestParam=%s \n"+
                            ",responResult=%s \n" +
                            ",thirdResponResult=%s.\n",
                    a.getId(), a.getChannel(), a.getAppKey(), a.getBusiCode(),
                    a.getIdentifyCode(), a.getThirdIdentifyId(), a.getCreateTime(),a.getUpdateTime(),
                    a.getCallbackTime(), a.getStatus(),
                    a.getRequestParam(),a.getThirdRequestParam(),a.getResponResult(),a.getThirdResponResult());
        }
        System.out.println("accessList=" + accessList.size());
    }
}
