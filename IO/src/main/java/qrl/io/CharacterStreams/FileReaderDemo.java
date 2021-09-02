package qrl.io.CharacterStreams;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\AccountBook.txt");
        int data;
        // 注意是字符数组
        char[] buf = new char[1024];
        while ((data=fileReader.read()) != -1){
            System.out.print(new String(buf));
        }
    }
}
