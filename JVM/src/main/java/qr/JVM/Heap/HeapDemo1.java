package qr.JVM.Heap;

/**
 * -Xms:10m -Xmx:10m
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("Start...");
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End...");
    }
}
