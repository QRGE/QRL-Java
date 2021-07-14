package qr.Java.Thread.Lock.ReentrantReadWriteLock;

/**
 * synchronized和ReentrantLock锁都是排它锁, 同一个时间内只允许一个线程执行同步代码块, 可以保证线程安全, 但是执行效率低
 *
 * ReentrantReadWriteLock读写锁是一种改进的排他锁, 也可以称为共享版的排他锁, 允许多个线程同时读取数据, 但是一次只允许一个线程对共享数据更新
 *      - 通过读锁与写锁完成读写操作, 线程在读取共享数据前必须先持有读锁, 读锁可以同时被多个线程持有(这个锁是共享的)
 *          - 任何一个线程拥有读锁时, 其他的线程都不能拥有写锁(为了保障没有线程进行数据更新,且拥有读锁线程读取的数据是最新的)
 *      - 更新数据时需要获取写锁, 写锁是排他的, 一个线程持有写锁是无法被其他线程持有写锁
 *          - 任何一个线程获取写锁时, 其他的线程都不能获取读锁
 *      - 读写锁: 读读共享, 读写互斥, 写写互斥
 *
 * java.util.concurrent.locks包中定义了ReadWriteLock接口, 该接口中readLock()返回读锁, writeLock()返回写锁
 *      - 实现类: ReentrantReadWriteLock
 */
public class concept {
}
