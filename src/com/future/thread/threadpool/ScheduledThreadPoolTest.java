package com.future.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/07
 */

/*
  3、newScheduledThreadPool：创建一个定长线程池，支持定时及周期性任务执行。
延迟执行示例代码如下：
表示延迟3秒执行。
 */
public class ScheduledThreadPoolTest {

     /* public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },3,TimeUnit.SECONDS);
    }*/

    //定期执行示例代码如下：

    //表示延迟1秒后每3秒执行一次。

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
