package qr.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: QR
 * @Date: 2021/7/27-16:35
 */
public class Times {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SS");

    public interface Task {
        void execute();
    }

    public static void test(Task task) {
        if (task == null) {
            return;
        }
        System.out.println("Begin: " + SIMPLE_DATE_FORMAT.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("End: " + SIMPLE_DATE_FORMAT.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("Spend time: " + delta + "秒");
        System.out.println("-------------------------------------");
    }
}
