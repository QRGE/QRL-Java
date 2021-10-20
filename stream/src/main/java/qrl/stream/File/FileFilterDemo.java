package qrl.stream.File;

import java.io.File;

/**
 * 在listFiles中传入一个文件过滤器接口重写器accept方法, 返回true时表示可接受File
 */
public class FileFilterDemo {

    public static void main(String[] args) {
        File dir = new File("D:\\MyDirectory");
        dir.listFiles(pathname -> {
            String fileName = pathname.getName();
            return fileName.endsWith(".png") || fileName.endsWith(".jpg");
        });
    }
}
