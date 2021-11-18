package org.qrl.juc.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * threadObj.getId(): 获取线程的Id值, 每个线程都有一个唯一的Id号
 */
public class Demo6_getId {

    private final static ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        // 每个线程都有自己的 id
        for (int i = 0; i < 20; i++) {
            threadPool.submit(()-> System.out.println("ThreadId: " + Thread.currentThread().getId()));
        }
    }
}
