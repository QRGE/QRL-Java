package qrl.juc.thread.Securtity;

/**
 * 有序性(Ordering)是指在什么情况下一个处理器运行的一个线程所执行的内存访问操作在另一个处理器运行的其他线程看起来是乱序的(Out of Order)
 * 乱序: 内存访问操作的顺序看起来发生了变化
 * 在多核处理器的环境下, 编写的顺序结构,这种操作执行的顺序可能是没有保障的:
 *    编译器可能会改变两个操作的先后顺序
 *    处理器也可能不会按照目标代码的顺序执行
 *    一个处理器上执行的多个操作, 在其他处理器来看它的顺序与目标代码指定的顺序可能不一样, 这种现象称为重排序
 *    重排序是对内存访问有序操作的一种优化, 可以在不影响单线程程序正确的情况下提升程序的性能, 但是可能对多线程程序的正确性产生影响, 极可能导致线程安全问题
 *
 * 与内存操作顺序有关的几个概念:
 *    源代码顺序, 即源码中指定的内存访问顺序
 *    程序顺序, 处理器上运行的目标代码所指定的内存访问顺序
 *    执行顺序, 内存访问操作在处理器上的实际执行顺序
 *    感知顺序, 给定处理器所感知到的该处理器及其他处理器的内存访问操作顺序
 *
 *  可以把重排序分为指令重排序和存储子系统重排序:
 *     指令重排序主要是由JIT编译器, 处理器引起的, 指程序顺序与实际执行顺序不一样
 *     存储子系统重排序是由高速缓存/写缓冲器引起的, 感知顺序与执行顺序不一致
 *
 *
 *  指令重排序
 */
public class ThreadOrdering {
}