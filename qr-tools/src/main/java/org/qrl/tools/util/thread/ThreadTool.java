package org.qrl.tools.util.thread;

import java.util.StringJoiner;

@SuppressWarnings("unused")
public class ThreadTool {
    
    public static void sleepSecond(long second){
        try {
            Thread.sleep(second * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void sleepMillisecond(long millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeAndThreadInfo(String tag){
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
}
