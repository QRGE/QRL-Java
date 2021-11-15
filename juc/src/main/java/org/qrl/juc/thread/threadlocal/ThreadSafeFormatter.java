package org.qrl.juc.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal使用的第一大场景
 */
public class ThreadSafeFormatter {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);

    // 利用ThreadLocal给每个线程分配自己的dateFormat对象, 保证了线程安全并且高效利用内存
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    public static String date(int seconds){
        Date date = new Date(1000L * seconds);
        SimpleDateFormat dateFormat = dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> System.out.println(date(finalI)));
        }
        threadPool.shutdown();
    }
}
