package qr.Java.Thread.ThreadPool.Monitor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor提供了一系列用于监控线程池的方法:
 *      - int getActiveCount()
 *      - int getCompletedTaskCount()
 *      - int getCorePoolSize()
 *      - int getLargestPoolSize()
 *      - int getMaximumPoolSize()
 *      - int getPoolSize()
 *      - BlockingQueue getQueue()
 *      - long getTaskCount()
 *      - long getCompletedTaskCount()
 */
public class MonitorThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = ()->{
            System.out.println("Thread" + Thread.currentThread().getId() + " is working");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.submit(r);
            System.out.println(
                            "CorePoolSize: " + threadPoolExecutor.getCorePoolSize() +
                            ", MaxPoolSize: " + threadPoolExecutor.getMaximumPoolSize() +
                            ", PoolSize: " + threadPoolExecutor.getPoolSize() +
                            ", ActiveCount: " + threadPoolExecutor.getActiveCount() +
                            ", getQueueSize: " + threadPoolExecutor.getQueue().size() +
                            ", TaskCount: " + threadPoolExecutor.getTaskCount() +
                            ", CompletedTaskCount: " + threadPoolExecutor.getCompletedTaskCount());
            Thread.sleep(1000);
        }
        threadPoolExecutor.shutdown();
    }
}
