package qr.Java.Thread.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 支持定期或周期执行任务
 * coolPoolSize: arg, maxPoolSize=Integer.MAX_VALUE, keepAliceTime=0, workQueue=DelayedWorkQueue
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        // scheduledThreadPool.schedule(new Task(), 1, TimeUnit.SECONDS); 定期执行任务
        scheduledThreadPool.scheduleAtFixedRate(new Task(), 1, 3, TimeUnit.SECONDS); // 周期执行任务
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
