package com.cheyipai.platformservice.thirdparty.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * <pre>
 * @Class role : 以静态变量保存Spring ApplicationContext,可在任何代码任何地方任何时候中取出ApplicaitonContext.
 *
 * 注:
 * classpath:spring/applicationContext.xml
 *
 * 	&lt!-- 注:此bean必须设置 lazy-init="false"--&gt
 * 	&ltbean class="com.tvj.core.util.SpringUtils" lazy-init="false"/&gt
 * 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 *
 * 例:
 * private ICache cache = SpringUtils.getBean("cache");
 *
 * @Package name : com.lefeng.passport.config.Environment
 * @Project name : passport
 * @author name : Andy King
 * @email addr : wkw11@163.com
 * @Create time : 2012-5-25 : 下午09:34:52
 * @ver curr : 1.0
 * </pre>
 */
public final class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     * 如果有多个Bean符合Class, 取出第一个.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        return (T) applicationContext.getBeansOfType(requiredType);
    }

    /**
     * 清除applicationContext静态变量.
     */
    public static void cleanApplicationContext() {
        applicationContext = null;
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringUtils");
        }
    }

    /**
     * 刷新SPRING的信息
     *
     * @param aContext
     */
    @SuppressWarnings("unchecked")
    public static void refreshSpring(ApplicationContext aContext) {
        Class[] cls = ClassUtils.getAllInterfaces(aContext);
        for (Class item : cls) {
            if (ConfigurableApplicationContext.class.getName().equals(
                    item.getName())) {
                System.out.println("refresh   Spring start ");
                long start = System.currentTimeMillis();
                ((ConfigurableApplicationContext) aContext).refresh();
                System.out.println("refresh   Spring end ; cost time (ms) :"
                        + (System.currentTimeMillis() - start));
            }
        }
    }

    /**
     * 刷新SPRING的信息
     */
    public static void refreshSpring() {
        refreshSpring(applicationContext);
    }
}