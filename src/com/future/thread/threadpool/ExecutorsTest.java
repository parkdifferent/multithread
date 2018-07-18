package com.future.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/05
 */

public class ExecutorsTest {

    private static final int NTHREDS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " hello");
            });
        }

    }
}
