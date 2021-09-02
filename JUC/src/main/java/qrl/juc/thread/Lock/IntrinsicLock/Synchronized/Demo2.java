package qrl.juc.thread.Lock.IntrinsicLock.Synchronized;

// 如果使用this作为锁对象, 那么在创建不同的对象时就不能保证此方法一次只能在一个线程中运行
public class Demo2 {

    public static void main(String[] args) {
        Demo2 demo1 = new Demo2();
        Demo2 demo2 = new Demo2();

        // 传入两个对象的testMethod(), 两个对象有两个锁, 不能实现同步
        new Thread(demo1::testMethod).start();
        new Thread(demo2::testMethod).start();

    }

    public void testMethod() {
        // 可以使用this当前对象作为锁对象, 锁的代码块里在某个时刻只能被一个线程执行
        synchronized (this){
            for (int i = 1; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }
}
