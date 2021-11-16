/**
 * 创建线程的几种方法:
 * <li>直接 new Thread() 并重写 run() 方法</li>
 * <li>通过 new 一个 Runnable 接口或者直接传入一个 lambda 表达式作为构造参数传入 Thread 的构造方法</li>
 * <li>借助 {@link java.util.concurrent.FutureTask} 接口, FutureTask 继承了 Runnable 接口</li>
 * tips:
 * <li>
 *     由于 Java 是单继承的, 利用实现 Runnable 接口的方法创造线程类可以实现更多功能<br/>
 *     其实都差不多, 接口是多继承的可能更方便扩展, 例如上面说的 FutureTask, 倒不如说 FutureTask 更加直观一点
 * </li>
 */
package org.qrl.juc.thread.basic.create;

