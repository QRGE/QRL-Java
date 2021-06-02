package qr.JVM.ClassLoader;

import sun.misc.Launcher;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderDemo2 {

    public static void main(String[] args) {
        // 查看BootstrapClassLoader能够加载的jar路径
        System.out.println("BootstrapClassLoader: ");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url: urLs) {
            System.out.println(url.toExternalForm());
        }

        // 测试url中的类是否是通过BootstrapClassLoader进行加载
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);
    }
}
