package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.entity.AccountDb;
import com.cheyipai.platformservice.thirdparty.utils.ApiUtils;
import com.cheyipai.platformservice.thirdparty.utils.CustomHttpClient;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import com.cheyipai.platformservice.thirdparty.utils.HttpClientFactory;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gongjunfeng on 2017/3/14.
 */
public class ApiControllerTest extends BaseBeanTest{

    @Test
    public void testApi() throws Exception{
        List<NameValuePair> params = new ArrayList<>();
        long timeStamp = System.currentTimeMillis();
        String appKey = "2";
        String appSecret = "33";
        String channel = "pc";
        String businessCode = "query";

        params.add(new BasicNameValuePair("serviceType","WZ"));
        params.add(new BasicNameValuePair("city","SH"));
        params.add(new BasicNameValuePair("hphm","浙AZ238U"));
        params.add(new BasicNameValuePair("appKey",appKey));

        params.add(new BasicNameValuePair("timeStamp",""+timeStamp));
        params.add(new BasicNameValuePair("channel",channel));
        params.add(new BasicNameValuePair("businessCode",businessCode));
        params.add(new BasicNameValuePair("engineno","61C1A5555"));


        AccountDb accountDb = DBUtil.getInstance().getAccountByAppKey(appKey,channel,businessCode);
        if(accountDb!=null){
            appSecret = accountDb.getAppSecret();
        }

        Map<String,String> map = new HashMap<>();
        for(NameValuePair pair : params){
            if(pair.getName().equals("sign")){
                continue;
            }
            map.put(pair.getName(),pair.getValue());
        }
        map = ApiUtils.sortMapByKey(map);
        String tos = ApiUtils.mapToString(map);
        String src = appSecret+tos+appSecret;
        String sign = DigestUtils.md5Hex(src);
        System.out.println("sign="+sign);
        System.out.println("src="+src);
        params.add(new BasicNameValuePair("sign", sign));

        HttpUriRequest request = HttpClientFactory.customHttpClient().buildHttpUriRequest("http://localhost:8080/api/v1","GET",params,3000);
        CustomHttpClient.HttpResult result = HttpClientFactory.customHttpClient().sendRequestGetEntityBytes(request);
        System.out.println(result.getContent());

    }
}
