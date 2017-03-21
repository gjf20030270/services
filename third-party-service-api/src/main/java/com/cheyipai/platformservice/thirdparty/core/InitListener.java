package com.cheyipai.platformservice.thirdparty.core;

import com.cheyipai.platformservice.thirdparty.impl.ThirdPartyServiceCacheImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * add by jiamingku 2017-03-09
 */
public class InitListener implements ServletContextListener, Runnable {

    public static final Logger LOG = LoggerFactory.getLogger(InitListener.class);

    private Thread initThread = null;

    private static long SLEEP_TIME = 1 * 60 * 1000;

    private long time = 0;

    public InitListener() {
    }

    private ApplicationContext ac1 = null;

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getServletContext());
        if (initThread == null) {
            initThread = new Thread(this);
            initThread.start();
        }
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public void run() {
        while (true) {
            try {
                long begin = System.currentTimeMillis();
                LOG.info("项目启动初始化开始(加载服务供应商信息)!");
                try {

                    ThirdPartyServiceCacheImpl.getInstance().reloadThirdPartyServiceDbs();
                    int thirdPartyServiceCount = ThirdPartyServiceCacheImpl.thirdPartyServices == null ? 0
                            : ThirdPartyServiceCacheImpl.thirdPartyServices.size();
                    int dbCnt = ThirdPartyServiceCacheImpl.serviceVendorDbs == null ? 0 : ThirdPartyServiceCacheImpl
                            .serviceVendorDbs.size();

                    LOG.info("加载服务供应商数据成功,共加载" + thirdPartyServiceCount + "条第三方记录! 数据库记录共 " +
                            dbCnt + "条记录");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                time = System.currentTimeMillis();
                long end = System.currentTimeMillis();
                LOG.info("项目启动初始化结束,共耗时:" + (end - begin) + "毫秒!");
            } catch (Exception e) {
            }
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
