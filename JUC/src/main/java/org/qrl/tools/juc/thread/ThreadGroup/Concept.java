package org.qrl.tools.juc.thread.ThreadGroup;

/**
 * 线程组和线程类似文件夹和文件, 数组和数的关系, 用于管理线程
 * 可以在线程组中定义一组相似(相关)的线程, 在线程组中也可以定义子线程组
 * Thread类的构造方法允许创建线程时指定线程组, 如果创建线程时没有指定线程组, 那么该线程就默认属于父线程组
 * 线程组现在比较少用
 *
 * ThreadGroup相关API:
 *      int activeCount(): 返回线程组及子线程的活跃线程数量
 *
 *      复制线程到线程组：
 *      threadGroupObj.enumerate(Thread[] list):
 *          将threadGroupObj的线程及子线程组全部线程存放到线程数组list中
 *      threadGroupObj.enumerate(Thread[] list, boolean recursive):
 *          将threadGroupObj的线程及子线程组全部线程存放到线程数组list中,
 *          如果recursive=false, 则不存放子线程组的数组
 *
 *      复制线程组到线程组：
 *      threadGroupObj.enumerate(ThreadGroup[] group):
 *          将当前线程组及其子线程组复制到group中
 *      threadGroupObj.enumerate(ThreadGroup[] group, boolean recursive):
 *          将当前线程组及其子线程组复制到group中, 如果recursive=false则只复制当前的线程组
 *
 *      interrupt(): 给当前线程组中的所有活跃线程设置中断标志
 *      setDaemon(boolean Daemon): 设置一个线程组为守护线程组
 *          守护线程组中可以有守护线程也可以有非守护线程
 */
public class Concept {
}
