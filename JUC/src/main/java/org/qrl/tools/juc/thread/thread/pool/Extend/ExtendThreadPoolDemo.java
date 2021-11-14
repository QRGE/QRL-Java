package org.qrl.tools.juc.thread.thread.pool.Extend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  ThreadPoolExecutor提供了两个方法:
 *      - protected void afterExecute(Runnable r, Throwable t)
 *      - protected void beforeExecute(Thread t, Runnable r)
 *  在线程池中执行某个任务前都会调用beforeExecute()方法, 结束后执行afterExecute()
 *  ThreadPoolExecutor中定义了一个内部类Worker, ThreadPoolExecutor线程池中的工作线程就是Worker类的实例, Worker实例在执行时也会调用
 *  beforeExecute()和afterExecute()方法
 */
public class ExtendThreadPoolDemo {

    private static class MyTask implements Runnable{

        private String name;

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is working in thread" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("Thread" + Thread.currentThread().getId() + " is ready to work: " + ((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(((MyTask) r).name + " is done.");
            }

            @Override
            protected void terminated() {
                System.out.println("ThreadPool worked done");
            }
        };

        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask("task-" + i);
            executorService.execute(myTask);
        }
        executorService.shutdown();
    }
}
