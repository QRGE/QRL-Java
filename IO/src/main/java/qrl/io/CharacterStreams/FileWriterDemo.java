package qrl.io.CharacterStreams;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("D:\\AccountBook.txt", true);
        for (int i = 0; i < 10; i++) {
            fileWriter.write("你还好吗?\n");
            fileWriter.flush();
        }
        fileWriter.close();
    }
}
