package com.future.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/06
 */

public class ThreadLocalTest {

    public static final ThreadLocal<SimpleDateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        String dateStamp = dateFormat.get().format(new Date());
        System.out.println(dateStamp);
    }
}
