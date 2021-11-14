package org.qrl.tools.juc.thread.thread.pool.ThreadFactory;

import java.util.Random;
import java.util.concurrent.*;

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
