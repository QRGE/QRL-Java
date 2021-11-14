package org.qrl.tools.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * juc.atomic 包下各种各种原子类都利用了 CAS 实现
 * @Author: QR
 * @Date: 2021/8/31-15:54
 */
public class atomicClass {

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.submit(()->{
                num.incrementAndGet();
            });
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(num);
    }
}
