package qr.Java.Thread.Exception;

/**
 * 如果想要获得run方法中出现的运行时异常信息, 可以通过回调UncaughtExceptionHandler接口获取哪个线程出现了运行时异常
 *
 * Thread类中处理运行时异常的API:
 *      Thread.get/setDefaultUncaughtExceptionHandler(): 获取/设置全局的默认UncaughtExceptionHandler
 *      threadObj.et/setUncaughtExceptionHandler(): 获取/设置当前线程的UncaughtExceptionHandler
 *
 * 线程发生异常时, JVM会调用Thread类的dispatchUncaughtException(Throwable e)方法,
 * 该方法会调用getUncaughtExceptionHandler().uncaughtException(this, e),
 * 如果想要获取线程中异常的信息, 就需要设置线程的UncaughtExceptionHandler
 *
 * 线程出现异常
 *     ↓
 * JVM调用Thread.dispatchUncaughtException()
 *              ↓
 * 如果设置了(Default)UncaughtExceptionHandler   ->   返回设置的UncaughtExceptionHandler
 *                                             ->   返回当前线程所在线程组的
 */
public class UncaughtExceptionHandlerDemo {
    public static void main(String[] args) {
        // 设置全局的UncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(
                (t, e) -> System.out.println("Get exception: " + e.getMessage() + " from " + t.getName())
        );

        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 算术异常
            System.out.println(12 / 0);
        }, "thread1").start();

        new Thread(()->{
            String name = null;
            // 空指针异常
            System.out.println(name.length());
        }, "thread2").start();
    }
}
