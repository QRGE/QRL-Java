package org.qrl.juc.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 除了控制资源的访问外, 还可以通过增加资源的方式保证线程安全, ThreadLocal主要解决了每个线程绑定自己的值(对象)
 *      - 多线程环境中, 把字符串转换成日期对象, 多个线程使用同一个SimpleDateFormat对象可能会产生线程安全问题, 有异常
 *      - 利用ThreadLocal可以为每个线程都指定自己的SimpleDateFormat对象
 *      - *利用ThreadLocalObj.set()对象, 其他线程可以通过ThreadLocalObj.get()设置的对象
 *
 * ThreadLocal的两大使用场景:
 *      1.每一个线程需要一个独享的对象(通常是工具类,典型需要使用的类有SimpleDataFormat和Random);
 *      2.每个线程内需要保存全局变量(例如拦截器中获取用户信息),可以让不同方法直接使用,避免参数传递的麻烦
 */
public class Demo1 {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // ThreadLocal很像是
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    static class ParseDate implements Runnable{

        private int i;

        public ParseDate(int i){
            this.i = i;
        }

        @Override
        public void run() {
            try {
                String text = "12:23:" + i%60;
//                Date date = sdf.parse(text);
//                System.out.println(i + " -- " + date);
                if (threadLocal.get() == null){
                    threadLocal.set(new SimpleDateFormat("HH:mm:ss"));
                }
                SimpleDateFormat sdf = threadLocal.get();
                Date date = sdf.parse(text);
                System.out.println(i + "--" + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new ParseDate(i)).start();
        }
    }
}
