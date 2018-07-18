package com.future.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

public class ConcurrentHashMapTest {

    private static final ConcurrentMap<String, Object> cache = new
            ConcurrentHashMap<>();

    // db
    private static Map<String, Object> map = new HashMap<>();

    public static final Object get(String key) {

        Object result = cache.get(key);
        if (result == null) {
            cache.put(key, map.get(key));
        }
        return result;
    }
}
