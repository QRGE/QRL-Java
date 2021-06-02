package qr.Java.IO.CharacterStreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\AccountBook.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 10; i++) {
            bw.write("我不太好");
            bw.newLine(); // 写入一个换行符, 当然也可以在bw.write内容的末尾加\n
            bw.flush();
        }
        bw.close();
        System.out.println("Done");
    }
}
