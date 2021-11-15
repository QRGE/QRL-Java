package org.qrl.juc.thread.pool.factory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = ()->{
            try{
                int num = new Random().nextInt();
                long id = Thread.currentThread().getId();
                TimeUnit.SECONDS.sleep(num);
                System.out.println("Thread" + id + " worked " + num + "s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            r1 -> {
                Thread thread = new Thread(r1);
                thread.setDaemon(true);
                return thread;
            }
        );
        for (int i = 0; i < 5; i++) {
            executorService.submit(r);
        }

        TimeUnit.SECONDS.sleep(5);
    }
}
