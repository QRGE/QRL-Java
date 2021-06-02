package qr.Java.Thread.ThreadPool.Handler;

import java.util.Random;
import java.util.concurrent.*;

public class RejectedExecutionHandlerDemo {

    public static void main(String[] args) {
        Runnable r = ()->{
            try {
                int num = new Random().nextInt();
                System.out.println("Thread" +Thread.currentThread().getId() + " work " + num + "s");
                TimeUnit.SECONDS.sleep(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            5, 10, 0,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
                (r1, executor) -> {
                    // r: 待处理任务, executor: 当前线程池
                    System.out.println(r1 + " is discarding...");
                }
        );

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            threadPoolExecutor.submit(r);
        }
    }
}
