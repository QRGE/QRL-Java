package org.qrl.juc.thread.Lock.ReentrantReadWriteLock;

/**
 * 读写互斥, 一个线程获取读锁时, 写线程等待; 一个线程获取写锁时, 其他线程等待
 */
public class Demo2 {
    public static void main(String[] args) {
        Service service = new Service();
        // 还是看执行顺序, 都是读的线程执行完毕后再执行写的线程
        new Thread(service::read).start();
        new Thread(()->{
            service.write(3);
        }).start();
    }
}
