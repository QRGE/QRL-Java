package org.qrl.juc.thread.basic.create;

public class Demo2_Runnable implements Runnable{

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Demo2_Runnable());
        thread1.start();
        // Runnable() 是一个函数时接口可以直接传入一个 lambda 表达式
        new Thread(()-> System.out.println("Create a runnable by lambda")).start();
    }

    @Override
    public void run() {
        System.out.println("Create thread by implement Runnable");
    }
}
