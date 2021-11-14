package org.qrl.tools.util.time;

import org.qrl.tools.constant.TimeUnit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: QR
 * @Date: 2021/7/27-16:35
 */
public class TimeTool {

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

    /**
     * 计算两个纳秒级别的差值, 返回指定时间单位的差值数
     * @param start 开始时间
     * @param end 结束时间
     * @param timeUnit 时间单位 {@link org.qrl.tools.constant.TimeUnit}
     * @return 指定时间单位的差值数
     */
    public static long nsDifference(long start, long end, TimeUnit timeUnit){
        long difference = end - start;
        switch (timeUnit){
            case ms -> {
                return difference / 1000 / 1000;
            }
            case s -> {
                return difference / 1000/ 1000/ 1000;
            }
            default -> {
                return Long.MIN_VALUE;
            }
        }
    }
}
