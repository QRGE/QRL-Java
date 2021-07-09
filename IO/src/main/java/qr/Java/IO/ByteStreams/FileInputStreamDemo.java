package qr.Java.IO.ByteStreams;

import org.junit.Test;
import qr.Java.IO.Utils.FileUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

    @Test
    public void readByByte() throws IOException {
        FileInputStream fis = new FileInputStream(FileUtils.getFile("Note.txt"));
        int data;
        // 每个字节读一次
        while ((data = fis.read()) != -1){
            System.out.print((char) data);
        }
        fis.close();
    }

    @Test
    public void readByBytes() throws IOException {
        FileInputStream fis = new FileInputStream(FileUtils.getFile("Note.txt"));
        byte[] bytes = new byte[8];
        // 一次读多个字节到一个字节数组中
        while ((fis.read(bytes) != -1)){
            System.out.println(new String(bytes));
        }
        fis.close();
    }
}
