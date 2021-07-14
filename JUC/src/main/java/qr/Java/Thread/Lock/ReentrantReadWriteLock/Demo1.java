package qr.Java.Thread.Lock.ReentrantReadWriteLock;

/**
 * ReadWriteLock可以
 *      实现读读共享, 允许多个线程获得读锁
 *      写写互斥, 写锁一次只能由一个线程获得
 *      读写互斥, 一个线程获取读锁时, 写线程等待; 一个线程获取写锁时, 其他线程等待
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        // 注意以下读写的运行时间比较
        Service service = new Service();
        for (int i = 0; i < 10; i++) {
            new Thread(service::read).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                service.write(finalI);
            }).start();
        }

        Thread.sleep(7000);

        System.out.println("service's num:" + service.getNum());
    }
}
