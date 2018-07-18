package com.future.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

public class CustomizeThreadPool {

    private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 40, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(100), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {

        for (int i = 0; i < 500; i++) {
            final int j = i;
            threadPoolExecutor.execute(() -> {
                System.out.println(j);
            });
        }
    }

}
