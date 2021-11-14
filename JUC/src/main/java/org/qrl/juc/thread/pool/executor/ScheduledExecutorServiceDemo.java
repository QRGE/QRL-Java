package org.qrl.juc.thread.pool.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        // 有调度功能的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        scheduleDemo(scheduledThreadPool);
        //  scheduleAtFixedRateDemo(scheduledThreadPool);
        scheduleWithFixedDelayDemo(scheduledThreadPool);
    }

    private static void scheduleWithFixedDelayDemo(ScheduledExecutorService scheduledThreadPool) {
        scheduledThreadPool.scheduleWithFixedDelay(
                () -> {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getId() + " is working");
                        // 模拟程序运行时长
                        TimeUnit.SECONDS.sleep(5);
                        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                        System.out.println("Work Done! Work time: " + sdf.format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                3, // 3个单位时间后执行一次任务
                2, // 无论运行耗时多久, 结束后两秒都会再次开次一个新任务, 即 运行间隔 = 程序运行时长 + 指定间隔时间
                TimeUnit.SECONDS // 时间单位
        );
    }

    private static void scheduleDemo(ScheduledExecutorService scheduledThreadPool) {
        scheduledThreadPool.schedule(
                () -> System.out.println("Thread " + Thread.currentThread().getId() + " is working"),
                2, // 2个单位时间后执行任务
                TimeUnit.SECONDS // 时间单位
        );
    }

    private static void scheduleAtFixedRateDemo(ScheduledExecutorService scheduledThreadPool) {
        scheduledThreadPool.scheduleAtFixedRate(
                () -> {
                    try {
                        System.out.println("Thread " + Thread.currentThread().getId() + " is working");
                        // 模拟程序运行时长
                        TimeUnit.SECONDS.sleep(7);
                        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                        System.out.println("Work Done! Work time: " + sdf.format(new Date()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                3, // 3个单位时间后执行一次任务
                2, // 之后每隔2个单位时间就会执行一次任务, 实际间隔时间 = 指定间隔时间 > 任务时长 ? 间隔时间 : 任务时长
                TimeUnit.SECONDS // 时间单位
        );
    }
}
