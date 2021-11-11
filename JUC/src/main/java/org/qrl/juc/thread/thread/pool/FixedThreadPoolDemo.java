package org.qrl.juc.thread.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool是固定的线程池
 * workQueue: LinkedBlockingQueue, corePoolSize=maxPoolSize=arg, KeepAliveTime:0s
 *      如果一直往里面添加线程可能会导致OOM异常
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 观察输出结构的线程名称, 可以看到结果始终保持在1到5之间
        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(new Task());
        }
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
