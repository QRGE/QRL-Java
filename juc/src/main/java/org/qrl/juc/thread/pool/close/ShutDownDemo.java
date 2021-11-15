package org.qrl.juc.thread.pool.close;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * shutdown(): 让线程池进入关闭状态, 不过线程会让在正在运行的线程以及等待执行的线程全部执行完毕后再进入关闭状态
 * isShutdown(): 判断线程池是否为关闭状态
 * isTerminated(): 判断线程池是否完全进入关闭状态
 * awaitTermination(n , TimeUnit): 让线程阻塞n秒, 并检测线程再阻塞时间内是否执行完毕, 返回一个布尔值
 * shutDown(): 让线程池立刻停止工作, 中断当前正在工作的线程, 并返回workQueue里存在的未运行的线程对象
 */
public class ShutDownDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 观察输出结构的线程名称, 可以看到线程数始终保持在1到5之间
        for (int i = 0; i < 100; i++) {
            fixedThreadPool.execute(new Task());
        }
        System.out.println(fixedThreadPool.awaitTermination(3, TimeUnit.SECONDS)); // 让线程阻塞n秒, 并检测线程再阻塞时间内是否执行完毕, 返回一个布尔值
        fixedThreadPool.shutdown(); // shutDown会等待正在执行的线程以及等待的线程执行完毕后再关闭,即这里会等待上面开启的1000个线程都执行完毕再关闭线程池
        Thread.sleep(1500); // 等待线程运行完
        System.out.println("IsShutDown: " + fixedThreadPool.isShutdown()); // 判断是否进入停止状态
        System.out.println("IsTerminated: " + fixedThreadPool.isTerminated()); // 判断线程池是否完全进入状态
        fixedThreadPool.execute(new Task()); // 线程池已经关闭再提交任务就会报错

    }

    @Test
    void shutDownNow(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            fixedThreadPool.execute(new Task());
        }
        List<Runnable> runnable = fixedThreadPool.shutdownNow(); // 立刻停止线程运行, 返回一个runnable,
        for (Runnable aRunnable : runnable) {
            aRunnable.run(); // 都是Runnable的实现类, 可以放进线程池重新运行
        }
    }

    static class Task implements Runnable{

        private final Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock){
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is disrupted");
                }
            }
        }
    }
}
