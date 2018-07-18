package com.future.thread.AbstractQueuedSynchronizer;

import java.util.concurrent.CountDownLatch;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

/**
 * D begin to work after a,b,c finished their work.
 */
public class CountdownLatchTest {

    static int worker = 3;
    private static CountDownLatch countDownLatch = new CountDownLatch(worker);

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("D is waiting for other three threads");
            try {
                countDownLatch.await();
                System.out.println("All done, D starts working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (char threadName='A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(() -> {
                System.out.println(tN + " is working");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(tN + "finished");
                countDownLatch.countDown();
            }).start();
        }
    }



}
