package qr.util.file;

import java.util.Objects;

/**
 * File 工具类
 * @Author: QR
 * @Date: 2021/9/2-23:55
 */
public class FileTool {

    public static String getResourcesFilePath(String fileName){
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        return (path + fileName).substring(1);
    }

    public static void main(String[] args) {
        System.out.println(getResourcesFilePath("AAA"));
    }
}
