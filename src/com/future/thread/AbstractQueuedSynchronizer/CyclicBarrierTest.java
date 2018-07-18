package com.future.thread.AbstractQueuedSynchronizer;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

/**
 *  a, b, c have all ready, run together.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName='A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);

            new Thread(() -> {
                int r = ThreadLocalRandom.current().nextInt(0, 10000);
                System.out.println(rN + " is preparing for time:" + r);
                try {
                    Thread.sleep(r);
                    System.out.println(rN + " is prepared, waiting for others");
                    cyclicBarrier.await(); // 当前运动员准备完毕，等待别人准备好
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(rN + "starts running"); // 所有运动员都准备好了，一起开始跑
            }).start();
        }
    }
}
