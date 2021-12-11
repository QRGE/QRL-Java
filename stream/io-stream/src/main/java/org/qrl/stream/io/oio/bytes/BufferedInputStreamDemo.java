package org.qrl.stream.io.oio.bytes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 缓冲流: BufferedInputStream/BufferedOutputStream
 *      可以提高IO效率, 减少访问磁盘的次数
 *      数据存储在缓冲区中, flush是将缓存区的内容写入文件中, 也可以直接close
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Note.txt"));
            int data;
            while ((data = bis.read())!= -1){
                System.out.println((char) data);
            }
            // 关闭bufferInputStream同时也会关闭传入的FileInputStream
            bis.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
