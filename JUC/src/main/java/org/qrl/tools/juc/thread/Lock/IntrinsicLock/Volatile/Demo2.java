package org.qrl.tools.juc.thread.Lock.IntrinsicLock.Volatile;

// volatile不保证原子性
public class Demo2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }

    static class MyThread extends Thread{
        /**
         * synchronized利用了排他性实现了原子性
         * 而volatile只实现了线程是从主内存中读取数据, 并无法保证方法只能在一个线程中执行, 无法保证原子性
         */
        volatile public static int count;

//        public static void addCount(){
//            for (int i = 0; i < 1000; i++) {
//                count++; // 其实编译器都会发出警告
//            }
//            System.out.println(Thread.currentThread().getName() + ", count= " + count);
//        }

        // 使用了synchronized即实现了原子性, 可以查看两种方法的结果
        public synchronized static void addCount(){
            for (int i = 0; i < 1000; i++) {
                count++; // 其实编译器都会发出警告
            }
            System.out.println(Thread.currentThread().getName() + ", count= " + count);
        }

        @Override
        public void run(){
            addCount();
        }
    }
}
