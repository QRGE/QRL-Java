package org.qrl.juc.thread.basic;

/**
 * @author qr
 * @date 2021/11/15 1:06 PM
 */
public class HelloWorld {

    public static void main(String[] args) {
        MyFirstThread thread = new MyFirstThread();
        thread.start();
    }
}
class MyFirstThread extends Thread{
    @Override
    public void run() {
        System.out.println("My first thread!");
    }
}
