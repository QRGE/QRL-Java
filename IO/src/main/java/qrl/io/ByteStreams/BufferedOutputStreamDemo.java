package qrl.io.ByteStreams;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) {
        String filename = "D:\\Note.txt";
        try {
            // 在FileOutputStream()
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename, true));
            for (int i = 0; i < 1000; i++) {
                bos.write("WoBuHao\n".getBytes(StandardCharsets.UTF_8));
                // bufferedOutputStream每次写入的数据都会写进缓冲区, 需要调用flush或close才会真正写入指定文件中
                bos.flush();
            }
            bos.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
