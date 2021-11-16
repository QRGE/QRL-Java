package org.qrl.juc.thread.basic.stop;

/**
 * stop() 已经被作废，强制让线程停止可能存在的问题:
 * <li>些清理性的工作得不到完成</li>
 * <li>对锁定的对象进行了"解锁", 导致数据得不到同步的处理, 出现线程安全问题</li>
 * @author qr
 * @date 2021/11/15 11:43 AM
 */
public class Demo3_Stop {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            int i = 0;
            while (true){
                System.out.println(i++);
            }
        }, "thread_basic_stop_demo3");
        thread.start();

        try {
            Thread.sleep(20);
            // threadObj().stop() 此方法已经过时
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ThreadDeath threadDeath){
            System.out.println("调用 stop() 方法会抛出 ThreadDeath 异常");
            threadDeath.printStackTrace();
        }
    }
}
