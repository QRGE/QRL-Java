package qr.Java.IO.TransformStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流, 可以设置指定的编码读取字节流
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\AccountBook.txt"), StandardCharsets.UTF_8);
        int data;
        byte[] bytes = new byte[1024 * 8];
        while ((data = isr.read()) != -1){
            System.out.println(data);
        }
        isr.close();
    }
}
