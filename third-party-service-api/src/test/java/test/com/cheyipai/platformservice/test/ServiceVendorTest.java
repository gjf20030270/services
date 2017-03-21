package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.bean.Constants;
import com.cheyipai.platformservice.thirdparty.entity.ServiceVendorDb;
import com.cheyipai.platformservice.thirdparty.mapper.ServiceVendorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiamingku on 2017/3/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-root-context.xml"})
public class ServiceVendorTest {

    @Resource
    private ServiceVendorMapper serviceVendorMapper;


    @Test
    public void geServiceVendors() {
        Map<String, Object> map = new HashMap<>();
        List<ServiceVendorDb> serviceVendorDbs = serviceVendorMapper.getServiceVendors(map);
        System.out.println("count:" + serviceVendorDbs.size());
        for (ServiceVendorDb db : serviceVendorDbs) {
            System.out.println(db);
        }
    }

    /**
     * @param code        聚合：JUHE
     *                    极速：JISU
     * @param serviceType
     * @param name
     */
    public void addServiceVendors(String code, String serviceType, String name) {
        ServiceVendorDb svdb = new ServiceVendorDb();
        for (int i = 0; i < 4; i++) {
            svdb.setCode(code);
            svdb.setServiceType(serviceType);
            svdb.setName(name + i);
            svdb.setAccount("account-" + i);
            svdb.setCallbackUrl("callbackUrl-" + i);
            svdb.setChargeBasic("1/500-" + i);
            svdb.setSettlementType("次结");
            svdb.setAppKey("appkey" + i);
            svdb.setAppSecret("appsecret" + i);
            svdb.setCreateTime(new Date());
            svdb.setServiceStartTime(new Date());
            svdb.setRequestMethod("POST");
            svdb.setServiceStopTime(new Date());
            svdb.setRequestTimeOut("300");
            svdb.setLevel(getLevel(i));
            if (i == 2) {
                svdb.setStatus(0);
            } else {
                svdb.setStatus(1);
            }
            svdb.setName("name-" + i);
            svdb.setRequestTimeOut("300");
            svdb.setRequestUrl("http://www.baidu.com-" + i);
            serviceVendorMapper.addServiceVendor(svdb);
        }

    }

    /**
     *
     */
    @Test
    public void addAllServiceVendors() {
        ServiceVendorDb svdb = new ServiceVendorDb();

        addServiceVendors(Constants.SERVICE_VENDOR_JUHE, "WZ", "聚合");

        addServiceVendors(Constants.SERVICE_VENDOR_JISU, "WZ", "极速");
    }

    public int getLevel(int i) {
        int a = 0;
        switch (i) {
            case 1:
                a = 10;
                break;
            case 2:
                a = 9;
                break;
            case 3:
                a = 8;
                break;
            case 4:
                a = 7;
                break;
            case 5:
                a = 6;
                break;
            case 6:
                a = 5;
                break;
            case 7:
                a = 4;
                break;
            case 8:
                a = 3;
                break;
            case 9:
                a = 2;
                break;
            case 10:
                a = 1;
                break;
            default:
                a = 100;
                break;

        }
        return a;
    }
}
