package qr.Java.Thread.Basic;

import org.junit.jupiter.api.Test;

public class ThreadTests {

    // Thread.sleep()可以暂停调用此方法的线程, 测试类里似乎不能使用Thread.sleep(), 可以看MyThread的main方法
    @Test
    void sleepTest(){
        MyThread7 myThread7 = new MyThread7();
        long startTime = System.currentTimeMillis();
        myThread7.start();
        long endTime = System.currentTimeMillis();
        System.out.println("Main, pass: " + (endTime - startTime));
    }

    // 每一个线程都已自己的唯一Id
    // 通过getId()可以获取线程的Id
    @Test
    void getIdTest(){
        System.out.println("ThreadName: " + Thread.currentThread().getName() + ", id: " + Thread.currentThread().getId());
        for (int i = 0; i < 5; i++) {
            new MyThread8().start();
        }
    }

    // Thread.yield()方法可以让当前线程放弃CPU资源
    @Test
    void yieldTest(){
        MyThread9 myThread9 = new MyThread9();
        myThread9.start();

        long begin = System.currentTimeMillis();
        long sum = 0L;
        for (int i = 0; i < 100000; i++) {
            sum += i;
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("Main Pass: " + (end - begin));
    }

    // setProperty()方法可以设置线程的优先级, 优先级的取值范围为0到10依次递增
    // main线程的优先级为5, 优先级是可以继承的, 即如果在A线程中创建了B线程, 那么B线程的优先级等同于A线程的优先级, 也就是说所有在main线程中创建的线程的优先级均为5
    @Test
    void priorityTest(){
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread B is working! " + i);
            }
        });
        threadA.setPriority(1);
        threadA.start();

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread A is working! " + i);
            }
        });
        threadB.setPriority(10);
        threadB.start();
    }

    // threadObj.interrupt() 设置中断标记
    // threadObj.isInterrupt() 查询是否有中断标记
    // interrupt()仅仅是给线程设置一个中断标记
    // 真正退出线程的可以在对应线程中run()里利用isInterrupted()方法判断是否有有中断标记,然后利用return等结束方法
    @Test
    void interruptTest(){
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (Thread.currentThread().isInterrupted()){
                    return; // 利用return方法结束run方法,即线程的run方法执行完毕,线程也结束
                }
                System.out.println("MyThread: " + i);
            }
        });
        myThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main: " + i);
        }
        myThread.interrupt();
    }

    /**
     *  setDaemon(boolean on): 设置一个线程是否为守护线程
     *  Java中的线程分为用户线程和守护线程
     *  守护线程是为其他线程提供服务的,GC(垃圾回收器)就是一个典型的守护线程
     *  守护线程不能单独运行, 当JVM中没有其他用户线程, 只有守护线程时,JVM会退出
     *  设置守护线程的代码应该在start()方法前
     */
    @Test
    void DaemonTest(){
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("MyThread is working... " + i);
            }
        });
        myThread.setDaemon(true);
        myThread.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("MainThread is working... " + i);
        }
    }

    /**
     * getState()可以获取线程状态, 线程的状态是Thread.State枚举定义的, 如下几种:
     * NEW: 新建状态, 创建了线程对象, 在调用start()之前
     * RUNNABLE: 可运行状态, 包括了READY和RUNNING,
     * READY: 表示该线程可以被线程调度器进行调用, 但还有被调用, 即调用start()且还没有被线程调度器调用
     * RUNNING: 被线程调度器调用了, 表示正在执行run方法
     *      yield()方法可以把线程从RUNNING状态转换成READY状态
     * BLOCKED: 阻塞状态, 线程发起阻塞的IO操作或者申请由其他线程占用的资源(申请锁,即锁被其他线程占用),处于阻塞状态的线程不会占用CPU的资源,
     *          当阻塞I/O执行完,或者线程得了其申请的资源,线程可以转换为RUNNABLE
     * WAITING: 线程执行了threadObj.wait(),或者thread.join()方法会把线程转换成WAITING等待状态,
     *          执行object.notify()方法,或者加入线程执行完毕,当前线程会转换为RUNNABLE状态
     * TIMED_WAITING: 与WAITING,都是等待状态, 区别在于处于该线程不会无限得等待, 如果线程没有在指定的时间范围内完成期望操作, 该线程会自动转化为RUNNABLE
     *                个人理解就是个有时间限制的WAITING,例如Thread.sleep(int ms), 仅休眠了n毫秒后还是会继续执行当前线程
     * TERMINATED: 终止状态, 线程结束处于终止状态
     */
    @Test
    void stateTest() throws InterruptedException {
        Thread myThread = new Thread(() -> System.out.println("MyThread is working..."));
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        Thread.sleep(2000);
        System.out.println(myThread.getState());
    }


    /**
     * 多线程编程具有的优势:
     *    1)提高系统的吞吐率(Throughout), 多线程编程可以使一个线程有多个并发(concurrent,即同时进行)操作
     *    2)提高响应性(Responsiveness),Web服务器会采用一些专业的线程负责处理用户的请求处理, 缩短用户的等待时间
     *    3)充分利用多核(Multicore)处理器资源, 通过多线程充分利用CPU的资源
     * 多线程存在的问题与风险:
     *    1)线程安全(Thread safety)问题,多线程共享数据时,没有采取正确的并发访问控制措施, 就可能会产生一些数据一致性的问题,
     *    例如: 读取脏数据(过期的数据), 如丢失数据更新
     *    2)线程活性(Thread liveness)问题, 由于程序自身的缺陷或者由资源的稀缺性导致线程一直处于非RUNNABLE状态,常见的活性故障由几种:
     *        死锁(DeadLock): 类似鹬蚌相争
     *        锁死(Lockout): 类似睡美人, 如果王子挂了, 那么睡美人永远不会醒
     *        活锁(LiveLock): 类似你去找工作, 别人要有工作经验的人, 而你不工作就没有工作经验
     *        饥饿(Starvation): 饱汉不知饿汉饥, 饱汉一直抢资源饿汉饿死了
     *    3):上下文切换(Context Switch),处理器执行从一个线程切换到另一个线程
     *    4):可靠性: 可能会由一个线程导致 JVM 意外终止, 其他的线程也无法执行
     */
    @Test
    void advantageOrShortage(){

    }
}
