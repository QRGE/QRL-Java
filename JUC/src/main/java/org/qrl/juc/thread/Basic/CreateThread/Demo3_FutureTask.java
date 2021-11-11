package org.qrl.juc.thread.Basic.CreateThread;

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

        // main线程通过task不断访问SubThread获得其返回值, 当SubThread运行结束后main线程才能获得其返回值
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
