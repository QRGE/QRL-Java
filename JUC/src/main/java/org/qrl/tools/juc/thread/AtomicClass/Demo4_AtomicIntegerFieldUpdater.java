package org.qrl.tools.juc.thread.AtomicClass;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFiledUpdater类可以对原子字段进行更新, 被更新字段的要求:
 * - 字符必须使用volatile修饰, 使其在线程之间可见
 * - 只能是实例变量, 不能是静态变量, 当然也不能被final修饰
 */
public class Demo4_AtomicIntegerFieldUpdater {

    public static void main(String[] args) throws InterruptedException {
        User aUser = new User(1, 23);
        for (int i = 0; i < 10; i++) {
            new MyThread4(aUser).start();
        }

        Thread.sleep(2000);

        System.out.println(aUser);
    }
}

class MyThread4 extends Thread{
    private final User user;
    private static final AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public MyThread4(User user) {
        this.user = user;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(updater.getAndIncrement(user));
        }
    }
}

class User{

    int id;
    volatile int age;

    public User(int id, int age){
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
