package qr.JVM.ClassLoader;

/**
 * 常见的获取ClassLoader方式
 */
public class GetClassLoaderDemo {

    public static void main(String[] args) {
        try {
            // 通过Class对象的getClassLoader()
            ClassLoader stringClassLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(stringClassLoader);

            // 通过Thread的getContextClassLoader获取当前线程上下文的ClassLoader
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);

            // 通过ClassLoader类的getSystemClassLoader()
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            System.out.println(classLoader);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
