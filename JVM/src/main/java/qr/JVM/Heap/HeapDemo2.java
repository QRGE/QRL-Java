package qr.JVM.Heap;

import qr.Java.Utils.Thread.TSTools;

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

        TSTools.sleepMs(1000);
    }
}
