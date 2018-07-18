package com.future.thread;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducer {
  private static Buffer buffer = new Buffer();

  public static void main(String[] args) {
    // Create a thread pool with two threads
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new ProducerTask());
    executor.execute(new ConsumerTask());
    executor.shutdown();
  }

  // A task for adding an int to the buffer
  private static class ProducerTask implements Runnable {
    public void run() {
      try {
        int i = 1;
        while (true) {
          System.out.println("Producer writes " + i);
          buffer.write(i++); // Add a value to the buffer
          // Put the thread into sleep
          Thread.sleep((int)(Math.random() * 10000));
        }
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  // A task for reading and deleting an int from the buffer
  private static class ConsumerTask implements Runnable {
    public void run() {
      try {
        while (true) {
          System.out.println("\t\t\tConsumer reads " + buffer.read());
          // Put the thread into sleep
          Thread.sleep((int)(Math.random() * 10000));
        }
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  // An inner class for buffer
  private static class Buffer {
    private static final int CAPACITY = 1; // buffer size
    private LinkedList<Integer> queue = new LinkedList<Integer>();

    public synchronized void write(int value) {
      try {
        while (queue.size() == CAPACITY) {
          System.out.println("Wait for notFull condition");
          wait();
        }

        queue.offer(value);
        notifyAll(); // Signal notEmpty condition
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }

    public synchronized int read() {
      int value = 0;
      try {
        while (queue.isEmpty()) {
          System.out.println("\t\t\tWait for notEmpty condition");
          wait();
        }

        value = queue.remove();
        notifyAll(); // Signal notFull condition
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      return value;
    }
  }
}
