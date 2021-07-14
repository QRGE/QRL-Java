package qr.JVM.Heap;

import qr.basic.util.thread.ThreadTool;

/**
 * -Xms20m -Xmx20m
 */
public class HeapDemo2 {
    public static void main(String[] args) {
        System.out.println("Start...");
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End...");

        ThreadTool.sleepMs(1000);
    }
}
