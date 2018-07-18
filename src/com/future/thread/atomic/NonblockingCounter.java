package com.future.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

public class NonblockingCounter {

    private AtomicInteger value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (!value.compareAndSet(v, v + 1));
        return v + 1;
    }
}
