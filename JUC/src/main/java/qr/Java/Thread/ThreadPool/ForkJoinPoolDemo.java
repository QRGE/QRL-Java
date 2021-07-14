package qr.Java.Thread.ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * forkJoinPool采用"分而治之"的思想, 用于处理大数据的方法
 * 系统对forkJoinPool线程进行了优化, 通常情况下提交的任务数量和线程数量并不是一对一的关系, 多数情况下, 一个物理线程需要处理多个逻辑任务,
 *      优化方法: 假设线程B繁忙, 线程A空闲, 线程A会从线程B的任务队列(假设有个数组)中提取任务运行, A 在取 B 队列的任务时会从队列的底部提取
 */
public class ForkJoinPoolDemo {

    // RecursiveTask<>继承了ForkJoinPool接口
    // 计算 start 到 end 的数列之和
    private static class CountTask extends RecursiveTask<Long>{

        private final static int THRESHOLD = 10000; // 任务的阈值, 即数列的范围不会超出10000
        private final static int TASKNUM = 100;     // 任务过大时每次都会分解成 TASKNUM 个小任务

        private final long start;
        private final long end;

        public CountTask(long start, long end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            if (end - start < THRESHOLD){
                for (long i = start; i <= end; i++){
                    sum += i;
                }
            }else {
                long step = (end - start + 1) / TASKNUM;
                // 用于存放子任务方便join
                ArrayList<CountTask> tasks = new ArrayList<>();
                long pos = start;
                for (int i = 0; i < TASKNUM; i++) {
                    long lastOne = pos + step;
                    if (lastOne > end){
                        lastOne = end;
                    }
                    CountTask task = new CountTask(pos, lastOne);
                    tasks.add(task);
                    task.fork(); // 通过fork创建子任务
                    pos += step + 1;
                }

                for (CountTask task : tasks) {
                    sum += task.join();
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 200000000);
        ForkJoinTask<Long> result = forkJoinPool.submit(countTask);
        try {
            Long sum = result.get();
            System.out.println("The result of CountTask: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
