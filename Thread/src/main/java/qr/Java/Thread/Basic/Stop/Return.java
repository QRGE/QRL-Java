package qr.Java.Thread.Basic.Stop;

public class Return {

    public static void main(String[] args) throws InterruptedException {
        Thread thread7_2 = new Thread(() -> {
            int i = 0;
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                System.out.println(i++);
            }
        }, "thread7_2");
        thread7_2.start();
        Thread.sleep(200); // 让子弹飞一会

        thread7_2.interrupt();
        System.out.println("Stop!");
    }
}
