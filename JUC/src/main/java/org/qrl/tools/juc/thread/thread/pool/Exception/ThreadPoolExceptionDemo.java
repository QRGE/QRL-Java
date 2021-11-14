package org.qrl.tools.juc.thread.thread.pool.Exception;

import java.util.concurrent.*;

/**
 * 线程池利用submit提交任务时可能会忽略一些异常, 解决方法:
 * <li>重写submit方法</li>
 * <li>用execute方法执行任务</li>
 */
public class ThreadPoolExceptionDemo {

    public static void main(String[] args) {
        TraceThreadPollExecutor threadPoll = new TraceThreadPollExecutor(5, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 5; i++) {
            threadPoll.submit(new DivideTask(10, i));
        }
        threadPoll.shutdown();
    }

    private static class DivideTask implements Runnable{

        private final int x;
        private final int y;

        public DivideTask(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            System.out.println("Thread" + Thread.currentThread().getName() + " is calculating " +
                    x + " / " + y  + " = " + (x/y));
        }
    }

    private static class TraceThreadPollExecutor extends ThreadPoolExecutor{

        public TraceThreadPollExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                       TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public Runnable wrap(Runnable task, Exception exception){
            return () -> {
                try {
                    task.run();
                } catch (Exception e){
                    exception.printStackTrace();
                    e.printStackTrace();
                }
            };
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(wrap(task, new Exception("异常跟踪")));
        }
    }

    public static void submitTest(ExecutorService threadPool){
        // submit会吃掉 10 / 0 的情况, 也不报错
        for (int i = 0; i < 5; i++) {
            threadPool.submit(new DivideTask(10, i));
        }
        threadPool.shutdown();
    }

    public static void executeTest(ExecutorService threadPool){
        // execute
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new DivideTask(10, i));
            threadPool.execute(new DivideTask(10, 0));
        }
        threadPool.shutdown();
    }
}
