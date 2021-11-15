/**
 * 创建线程的几种方法:
 * <li>直接 new Thread() 并重写 run() 方法</li>
 * <li>通过 new 一个 Runnable 接口或者直接传入一个 lambda 表达式作为构造参数传入 Thread 的构造方法</li>
 * <li>借助 {@link java.util.concurrent.FutureTask} 接口, FutureTask 继承了 Runnable 接口</li>
 */
package org.qrl.juc.thread.basic.create;

