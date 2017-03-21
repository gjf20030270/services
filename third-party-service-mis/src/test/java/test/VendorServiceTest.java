package test;

import com.cheyipai.platformservice.thirdparty.bean.Vendor;
import com.cheyipai.platformservice.thirdparty.core.ResultMap;
import com.cheyipai.platformservice.thirdparty.service.VendorService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by miqi on 2017/3/17.
 */
public class VendorServiceTest extends BaseBeanTest{

    @Resource
    private VendorService vendorService;
    @Test
    public void testInsertVendor() {
        Vendor vendor = new Vendor();
        vendor.setName("4S");
        vendor.setAppKey("appKey1");
        vendor.setAppSecret("appSecret1");
        vendor.setAccount("61022222222222222");
        vendor.setCacheTime("1周");
        vendor.setCallbackUrl("https://123.sogou.com/");
        vendor.setChargeBasic("0.5/1");
        vendor.setCode("breakRulesCode");
        vendor.setCompanyPhone("15232352365");
        vendor.setContactsPhone("010-458488411");
        vendor.setContactsName("testuser1");
        vendor.setLevel(1);
        vendor.setNotifyType("异步");
        vendor.setRemark("4S违章查询");
        vendor.setReqparamMap("{'name':'测试'}");
        vendor.setRequestMethod("queryBreakRules");
        vendor.setRequestTimeOut("3000");
        vendor.setRequestUrl("https://");
        vendor.setServiceStartTime("2015-10-12 08:50:00");
        vendor.setServiceStopTime("2018-10-12 08:50:00");
        vendor.setNotifyType("异步");
        vendor.setServiceType("WZ");
        vendor.setSettlementType("月结");
        vendor.setStatus("1");
        vendor.setCacheTime("1天");
        vendorService.insertVendor(vendor);
        Long id = vendor.getId()==null ?-1L:vendor.getId().longValue();
        Assert.assertNotEquals("id为-1", -1, vendor.getId().longValue());
        System.out.println("插入成功");
    }
    @Test
    public void testDeleteVendor() {
        String id = "1049";
        ResultMap r = vendorService.deleteVendor(id);
        if ("1".equals(r.get("resCode")))
            System.out.println("删除成功");
    }
    @Test
    public void testUpdateVendor(){
        Vendor vendor = new Vendor();
        Integer id = 1049;
        vendor.setId(id);
        vendor.setName("4S2");
        vendor.setAppKey("appKey2");
        vendor.setAppSecret("appSecret1");
        vendor.setAccount("6103333333333");
        vendor.setCacheTime("2周");
        vendor.setCallbackUrl("https://123.sogou.com/test");
        vendor.setChargeBasic("0.2/1");
        vendor.setCode("breakRulesCode2");
        vendor.setCompanyPhone("15222222222");
        vendor.setContactsPhone("010-458488477");
        vendor.setContactsName("testuser2");
        vendor.setLevel(2);
        vendor.setNotifyType("同步");
        vendor.setRemark("4S违章查询2");
        vendor.setReqparamMap("{'name':'测试2'}");
        vendor.setRequestMethod("queryBreakRules2");
        vendor.setRequestTimeOut("2000");
        vendor.setRequestUrl("https://123.sogou.com/new");
        vendor.setServiceStartTime("2016-10-12 08:50:00");
        vendor.setServiceStopTime("2019-10-12 08:50:00");
        vendor.setServiceType("CF");
        vendor.setSettlementType("季结");
        vendor.setStatus("1");
        vendor.setCacheTime("2天");
        ResultMap r = vendorService.updateVendor(vendor);
        if ("1".equals(r.get("resCode")))
            System.out.println("插入成功");
    }
    @Test
    public void testSelectVendor() {
        List<Vendor> vendorList = vendorService.selectVendor();
        for (Vendor v : vendorList) {
            System.out.printf("id=%s,code=%s,name=%s,name=%s,serviceType=%s,reqparamMap=%s \n" +
                            ",requestUrl=%s,requestTimeOut=%s,requestMethod=%s,callbackUrl=%s \n"+
                            ",notifyType=%s,level=%s,serviceStartTime=%s,serviceStopTime=%s \n"+
                            ",createTime=%s,updateTime=%s,companyPhone=%s,contactsPhone=%s \n"+
                            ",contactsName=%s,account=%s,settlementType=%s,chargeBasic=%s \n"+
                            ",remark=%s,status=%s,appKey=%s,appSecret=%s,cacheTime=%s.\n",
                            v.getId(), v.getCode(),v.getName(), v.getServiceType(),v.getReqparamMap(),
                            v.getRequestUrl(), v.getRequestTimeOut(),v.getRequestMethod(),v.getCallbackUrl(),
                            v.getNotifyType(),v.getLevel(),v.getServiceStartTime(),v.getServiceStopTime(),
                            v.getCreateTime(),v.getUpdateTime(),v.getCompanyPhone(),v.getContactsPhone(),
                            v.getContactsName(),v.getAccount(),v.getSettlementType(),v.getChargeBasic(),
                            v.getRemark(),v.getStatus(),v.getStatus(),v.getAppKey(),v.getAppSecret(),v.getCacheTime());
        }
        System.out.println("vendorList=" + vendorList.size());
    }
}
