package com.future.thread.AbstractQueuedSynchronizer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/06
 */

public class ReadWriteLockTest {

    public static class Cache {

        private static Map<String, Object> map = new HashMap<>();

        private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        private static Lock readLock = rwl.readLock();
        private static Lock writeLock = rwl.writeLock();

        public static final Object get(String key) {
            readLock.lock();
            try {
                return map.get(key);
            } finally {
                readLock.unlock();
            }
        }

        public static final Object put(String key, Object value) {

            writeLock.lock();
            try {
                return map.put(key, value);
            } finally {
                writeLock.unlock();
            }
        }

        public static final void clear() {

            writeLock.lock();
            try {
                map.clear();
            } finally {
                writeLock.unlock();
            }
        }
    }

}
