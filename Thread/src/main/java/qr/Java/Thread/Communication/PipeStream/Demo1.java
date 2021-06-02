package qr.Java.Thread.Communication.PipeStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 使用PipedInputStream和PipedOutputStream管道字节流在线程之间传递数据
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
            in.connect(out); // 在输入管道流和输入管道流之间建立连接
            new Thread(()-> writeData(out)).start();
            new Thread(()-> readData(in)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(PipedOutputStream out){
        try {
            for (int i = 0; i < 100; i++) {
                String data = i + "";
                out.write(data.getBytes());
            }
            out.close(); // 注意关闭管道
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData(PipedInputStream in){
        try {
            byte[] bytes = new byte[8 * 1024]; // 将管道输入字节流中读取的字节保存到字节数组中
            int len = in.read(bytes);      // 返回读取到的字节个数, 如果没有读到任何数据返回-1
            while (len != -1){
                System.out.println(new String(bytes, 0, len));
                len = in.read(bytes);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
