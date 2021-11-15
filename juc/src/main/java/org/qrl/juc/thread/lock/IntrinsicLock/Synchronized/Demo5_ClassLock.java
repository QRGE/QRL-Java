package org.qrl.juc.thread.lock.IntrinsicLock.Synchronized;

// synchronized修饰static方法, 默认以 当前类时类对象 作为锁对象
public class Demo5_ClassLock {

    // 等用利用synchronized修饰静态方法
    public static void sMethod1(){
        synchronized (Demo5_ClassLock.class){
            for (int i = 1; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " --> " + i);
            }
        }
    }

    // synchronized修饰静态方法, 称为同步静态方法, 默认以 运行时类 作为锁对象
    public synchronized static void sMethod2(){
        for (int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + " -- >" + i);
        }
    }

    public static void main(String[] args) {

        new Thread(Demo5_ClassLock::sMethod1).start();
        new Thread(Demo5_ClassLock::sMethod2).start();
    }
}
