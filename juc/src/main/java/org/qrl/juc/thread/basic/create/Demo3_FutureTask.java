package org.qrl.juc.thread.basic.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo3_FutureTask {

    public static void main(String[] args) {
        Callable<String> callable = ()->{
            System.out.println("Implement callableInterface");
            return "Task Done";
        };
        FutureTask<String> task = new FutureTask<>(callable);
        Thread thread = new Thread(task, "SubThread");
        thread.start();

        // main 线程(或者其他地方)通过 FutureTask<>().get() 不断访问 SubThread 获得其返回值, 当 SubThread 运行结束后 main 线程才能获得其返回值
        // 如果 get() 的线程未开启会进入死锁
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
