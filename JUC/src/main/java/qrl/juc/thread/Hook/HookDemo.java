package qrl.juc.thread.Hook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hook线程也叫钩子线程, 当JVM退出时会执行Hook线程, 经常在程序启动时会创建一个.lock文件,
 * 用.lock文件校验程序是否启动, 在程序(JVM)退出时会删除.lock文件
 *
 * Hook线程中除了可以防止重新启动进程外, 还可以做资源释放
 */
public class HookDemo {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JVM退出, 会启动Hook线程, 在Hook线程中删除.lock文件");
            getLockFile().toFile().delete();
        }));

        if (getLockFile().toFile().exists()){
            throw new RuntimeException("程序已经启动!");
        }else {
            getLockFile().toFile().createNewFile();
            System.out.println("在启动时创建了lock文件");
        }
    }

    private static Path getLockFile(){
        return Paths.get("","temp.lock");
    }
}
