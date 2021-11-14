package org.qrl.tools.juc.thread.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newCachedThreadPool基本上可以容纳所有的线程
 *     workQueue: SynchronousQueue, corePoolSize=0, maxPoolSize=Integer.MAX_VALUE, keepAliceTime=60s
 *     具有自动回收多余线程的功能(如果某个线程60秒没有执行任务就会杀掉这个线程)
 *     当线程数量特别多的时候, 也有可能导致OOM
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            newCachedThreadPool.execute(new Task());
        }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
