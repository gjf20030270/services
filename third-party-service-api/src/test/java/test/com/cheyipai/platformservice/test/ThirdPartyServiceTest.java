package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.ThirdPartyService;
import com.cheyipai.platformservice.thirdparty.ThirdPartyServiceManager;
import com.cheyipai.platformservice.thirdparty.bean.Chain;
import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.impl.ThirdPartyServiceCacheImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-root-context.xml"})
public class ThirdPartyServiceTest {



    @Test
    public void testRequest() {


        ThirdPartyServiceCacheImpl thirdPartyServiceCache = (ThirdPartyServiceCacheImpl)ThirdPartyServiceCacheImpl.getInstance();

        thirdPartyServiceCache.reloadThirdPartyServiceDbs();

        Map<String, Chain> map = thirdPartyServiceCache.thirdPartyServiceChainMap;

        Iterator<String> iterator = map.keySet().iterator();

        while(iterator.hasNext()) {
            String serviceType = iterator.next();
            Chain chain = map.get(serviceType);

            System.out.println("servieType：" +serviceType +"  size:" +chain.getChainElements().size());

            for (ThirdPartyService thirdPartyService : chain.getChainElements()) {
                System.out.println(thirdPartyService.toString());
            }
        }

        Map<String, String> map1 = new HashMap<>();
        map1.put(Constants.SERVICE_TYPE, "WZ");
        Object o = ThirdPartyServiceManager.getInstance().getThirdPartyServiceResult(map1);

        System.out.println(o);
    }
}
