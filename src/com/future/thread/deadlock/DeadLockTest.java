package com.future.thread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/07
 */

public class DeadLockTest {

    private static DeadLock deadLock = new DeadLock();

    //jps  jstack pid  visualVM
    public static void main(String[] args) {

        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    deadLock.leftRight();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    deadLock.rightLeft();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
