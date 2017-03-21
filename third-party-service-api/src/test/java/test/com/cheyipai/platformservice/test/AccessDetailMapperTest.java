package test.com.cheyipai.platformservice.test;

import com.cheyipai.platformservice.thirdparty.entity.AccessDetailDb;
import com.cheyipai.platformservice.thirdparty.utils.DBUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by gongjunfeng on 2017/3/10.
 */
public class AccessDetailMapperTest extends BaseBeanTest {

    @Test
    public void testAddDetail() {
        AccessDetailDb detail = new AccessDetailDb();
        detail.setAccessId(1);
        detail.setCreateTime(new Date());
        detail.setRequestParam("{'requestparam':1}");
        detail.setResponseResult("{'responResult':2}");
        detail.setThirdRequestParam("{'thirdRequestParam':3}");
        detail.setThirdResponseResult("{'thirdResponseResult':4}");
        detail.setUpdateTime(new Date());
        DBUtil.getInstance().addAccessDetail(detail);
        System.out.println(detail.getId());
    }

    @Test
    public void testGetDetails() {
        List<AccessDetailDb> list = DBUtil.getInstance().getAccessDetails();
        for (AccessDetailDb detailDb : list) {
            System.out.println(detailDb.getId() + "," + detailDb.getAccessId() + "," + detailDb.getRequestParam() +
                    "," +
                    detailDb.getThirdRequestParam() + "," + detailDb.getResponseResult() + "," + detailDb
                    .getThirdResponseResult()
                    + "," + detailDb.getCreateTime() + "," + detailDb.getUpdateTime());
        }
    }

}
