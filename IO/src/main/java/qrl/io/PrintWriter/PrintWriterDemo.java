package qrl.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("D:\\print.txt");
        printWriter.print(97);
        printWriter.close();
        System.out.println("Done");
    }
}
