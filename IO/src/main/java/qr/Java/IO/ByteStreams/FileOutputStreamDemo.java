package qr.Java.IO.ByteStreams;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {

    @Test
    public void outputTest() throws IOException {
        // true表示追加模式, 即写入的内容添加到原内容后面, 否则为覆盖模式
        FileOutputStream fos = new FileOutputStream("D:\\Note.txt", true);
        fos.write(97);
        fos.close();
    }

    @Test
    public void writeByBytes() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Note.txt", true);
        String content = "Golang\n";
        fos.write(content.getBytes(StandardCharsets.UTF_8));
        fos.close();
    }
}
