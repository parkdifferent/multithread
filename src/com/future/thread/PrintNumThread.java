package com.future.thread;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/05
 */

public class PrintNumThread extends Thread {

    public static void main(String[] args) {

        // create thread
        PrintNumThread PrintNumThread = new PrintNumThread();
        // start thread
        PrintNumThread.start();
    }

    public PrintNumThread() {
    }

    // Override the run method in Runnable
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
