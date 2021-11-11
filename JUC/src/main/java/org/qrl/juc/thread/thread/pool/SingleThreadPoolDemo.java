package org.qrl.juc.thread.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * singleTheadPool只有一个线程容量, 任意时刻是由一个线程执行一个任务
 * corePoolSize=maxPoolSize=1, workQueue=LinkedBlockedSize, keepAliceTime=0
 */
public class SingleThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        singleThreadPool.execute(new Task());
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
