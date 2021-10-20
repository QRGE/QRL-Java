package qrl.stream.TransformStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\AccountBook.txt", true), "gbk");
        for (int i = 0; i < 10; i++) {
            osw.write("测试\n");
        }
        osw.close();
        System.out.println("Done");
    }
}
