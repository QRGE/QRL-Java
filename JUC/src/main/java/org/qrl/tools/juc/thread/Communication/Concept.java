package org.qrl.tools.juc.thread.Communication;

/**
 * 单线程中, 要执行的语句如果需要满足一定的条件才可以执行, 可以存放在if代码块中
 * 多线程中, 可能线程A条件还没有满足, 然后其他线程B执行后使得线程A运行条件满足
 *      - 线程之间存在依赖关系 或者 线程A可以控制其他线程
 */
public class Concept {
}
