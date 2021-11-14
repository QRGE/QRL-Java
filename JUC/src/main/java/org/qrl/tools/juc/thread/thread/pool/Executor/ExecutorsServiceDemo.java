package org.qrl.tools.juc.thread.thread.pool.Executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程的开销主要包括:
 *      <li>创建和启动的开销</li>
 *      <li>线程销毁的开销</li>
 *      <li>线程调度的开销</li>
 *      <li>线程数量受限于CPU处理器的数量</li></br>
 *
 * 线程池可以预先创建一定数量的工作线程, 客户端代码直接将任务作为一个对象提交给线程池, 线程池将这些任务缓存在工作队列中,
 * 线程池中的工作线程就不断从队列中取出任务并执行
 *
 * 线程池的组成部分:
 *     线程池管理器
 *     工作线程
 *     任务队列
 *     任务接口(Task)
 *
 *     ThreadPoolExecutor → AbstractExecutorsService → ExecutorService → Executor
 *     Executor: 只有一个execute用于执行方法
 *
 *     Executors: 一个工具类, 用于创建各种线程池
 *
 * 线程池的状态:
 *     RUNNING: 接受新任务并处理排队任务
 *     SHUTDOWN: 不接受新任务, 但处理排队任务
 *     STOP: 不接受新任务, 也不处理排队任务, 并中断正在进行的任务
 *     TIDYING: 所有任务已终止, workerCount为0, 线程会转换到TIDYING状态, 并将运行terminate()钩子方法
 *     TERMINATED: terminated()运行完成
 */
public class ExecutorsServiceDemo {

    public static void main(String[] args) {
        // 创建一个固定线程数量的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(()->{
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    System.out.println(Thread.currentThread().getId() + " is working! Time: " + sdf.format(new Date()));
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
