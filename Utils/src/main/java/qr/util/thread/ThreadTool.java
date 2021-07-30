package qr.util.thread;

/**
 * @author QR
 */
public class ThreadTool {

    public static void sleepMs(Integer ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepS(Integer s){
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
