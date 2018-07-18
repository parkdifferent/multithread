package com.future.thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/05
 */

public class SynchronizedCollections {

    private static Set<Integer> hashSet = Collections.synchronizedSet(new HashSet());

    public static void getResult() {
        synchronized (hashSet) { // Must synchronize it
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            int j = i;
            executor.execute(()-> {
                hashSet.add(j);
            });
        }

        /*Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(iterator.next());
        }*/


        synchronized (hashSet) { // Must synchronize it
            // The iterator is failfast
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

    }

}
