package qr.Java.Thread.AtomicClass;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo1_AtomicInteger {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }

    static class MyThread extends Thread{

        // 可以实现原子性
        private static final AtomicInteger count = new AtomicInteger(0);

        public static void addCount(){
            for (int i = 0; i < 1000; i++) {
                count.getAndIncrement(); // 相当于i++, 先get再increase, incrementAndGet反之
            }
            System.out.println(Thread.currentThread().getName() + ", count= " + count);
        }

        @Override
        public void run(){
            addCount();
        }
    }
}
