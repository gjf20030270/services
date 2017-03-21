package test.com.cheyipai.platformservice.test;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by jiamingku on 2017/3/12.
 */
public class HttpTest {


//    dtype	string	是	返回数据格式：json或xml或jsonp,默认json
//            json
//    callback	String	否	返回格式选择jsonp时，必须传递
//    city	String	是	城市代码 *
//    SH
//    hphm	String	是	号牌号码 完整7位 ,需要utf8 urlencode*
//    浙AZ327U
//    hpzl	String	是	号牌类型，默认02，暂只支持小型车
//    02
//    engineno	String	否	发动机号 (根据城市接口中的参数填写)
//    61C1A5555
//    classno	String	否	车架号 (根据城市接口中的参数填写)
//    LJ8H2A5BXBB009452
//            发送请求

    @Test
    public void testRequestJH() {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" running");
            }
        },1, TimeUnit.MINUTES);


        System.out.println(Thread.currentThread().getName()+" running");
    }

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        /*ScheduledFuture future =executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "begin running task");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " running off task");
            }
        }, 5, 5, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName()+" running");*/

        /*executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        Thread.sleep(1000 * 1);
        System.out.println("----------");

        CountDownLatch latch = new CountDownLatch(3);
        latch.await();*/

        Thread thread = Thread.currentThread();


        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("c");

    }
    public void test() throws InterruptedException {
        Object o = new Object();
        this.wait();
    }
}
