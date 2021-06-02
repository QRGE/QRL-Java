package qr.Java.Thread.Lock.IntrinsicLock.Synchronized;

// 使用常量作为锁对象
public class Demo3 {

    public static final Object lock = new Object();

    public void testMethod() {
        synchronized (lock){
            for (int i = 1; i <= 30; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }
    public static void staticMethod() {
        // 可以使用this当前对象作为锁对象, 锁的代码块里在某个时刻只能被一个线程执行
        synchronized (lock){
            for (int i = 1; i <= 30; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }


    public static void main(String[] args) {
        Demo3 lockDemo1 = new Demo3();
        Demo3 lockDemo2 = new Demo3();

        // 使用常量作为锁对象时, 即使在 "不同对象之间"或者"静态方法", 它们获取的锁对象是唯一的(即设置的常量), 可以实现同步
        new Thread(lockDemo1::testMethod).start();
        new Thread(lockDemo2::testMethod).start();
        new Thread(Demo3::staticMethod).start();

    }
}
