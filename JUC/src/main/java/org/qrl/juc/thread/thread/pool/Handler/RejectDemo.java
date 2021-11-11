package org.qrl.juc.thread.thread.pool.Handler;

/**
 * Rejected if pool is shutdown and task is then submitted
 *
 * 4中拒绝策略:
 *      AbortPolicy(): 抛出异常
 *      DiscardPolicy(): 丢弃线程任务
 *      DiscardOldestPolicy(): 丢弃在workQueue存在最久的任务
 *      CallerRunsPolicy(): 让提交的任务执行任务
 */
public class RejectDemo {

}
