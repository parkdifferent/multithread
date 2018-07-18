package com.future.thread;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/05
 */

// The task class for printing numbers from 1 to n for a given n
public class PrintNum implements Runnable  {

    private Integer lastNum;

    public PrintNum(Integer lastNum) {
        this.lastNum = lastNum;
    }

    public static void main(String[] args) {

        //System.out.println(Runtime.getRuntime().availableProcessors());

        // create task
        Runnable runnable = new PrintNum(10);
        // create thread
        Thread thread = new Thread(runnable);
        // start thread
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < lastNum; i++) {
            System.out.println(i);
        }
    }
}
