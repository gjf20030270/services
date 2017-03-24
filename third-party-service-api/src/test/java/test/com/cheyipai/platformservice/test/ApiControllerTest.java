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
        String appKey = "1fb6e774cb2346ef8bc991994cfe26be";
        String appSecret = "41f3fc129c9e0bb1c3aa4a0147712ca9";
        String channel = "PC";
        String businessCode = "busiCode1";

        params.add(new BasicNameValuePair("service_type","WZ"));
        params.add(new BasicNameValuePair("city","廊坊"));
        params.add(new BasicNameValuePair("hphm","冀RM0U31"));
        params.add(new BasicNameValuePair("app_key",appKey));

        params.add(new BasicNameValuePair("time_stamp",""+timeStamp));
        params.add(new BasicNameValuePair("channel",channel));
        params.add(new BasicNameValuePair("business_code",businessCode));
        params.add(new BasicNameValuePair("engineno","20806101"));
        params.add(new BasicNameValuePair("classno","A35173"));



        AccountDb accountDb = DBUtil.getInstance().getAccountByAppKey(appKey,channel,businessCode);
        if(accountDb!=null){
            appSecret = accountDb.getAppSecret();
        }

        Map<String,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("http://localhost:8080/api/v1?");
        for(NameValuePair pair : params){
            sb.append(pair.getName()).append("=").append(pair.getValue()).append("&");
            if(pair.getName().equals("sign")){
                continue;
            }
            map.put(pair.getName(),pair.getValue());
        }
        System.out.println(sb.toString());
        map = ApiUtils.sortMapByKey(map);
        String tos = ApiUtils.mapToString(map);
        String src = appSecret+tos+appSecret;
        String sign = DigestUtils.md5Hex(src);
        System.out.println("sign="+sign);
        System.out.println("src="+src);
        params.add(new BasicNameValuePair("sign", sign));


        HttpUriRequest request = HttpClientFactory.customHttpClient().buildHttpUriRequest("http://localhost:8080/api/v1","GET",params,3000);
        CustomHttpClient.HttpResult result = HttpClientFactory.customHttpClient().sendRequestGetEntityBytes(request);
        System.out.println("dddd"+result.getContent());

    }
}
