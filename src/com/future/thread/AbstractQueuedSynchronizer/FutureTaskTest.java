package com.future.thread.AbstractQueuedSynchronizer;

import java.util.concurrent.*;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

public class FutureTaskTest {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");

                int result = 0;
                for (int i = 1; i <= 100; i++) {
                    result += i;
                }
                Thread.sleep(2000);
                System.out.println("Task finished and return result");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        //new Thread(futureTask).start();
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(8);
        fixedThreadPool.execute(futureTask);

        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
