package qrl.io.CharacterStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\AccountBook.txt");
        BufferedReader br = new BufferedReader(fr);
        String data;
        // readLine(): 一行行读取, 遇到换行符或者null时读取结束
        while ((data = br.readLine())!=null){
            System.out.println(data);
        }
        br.close();
    }
}
