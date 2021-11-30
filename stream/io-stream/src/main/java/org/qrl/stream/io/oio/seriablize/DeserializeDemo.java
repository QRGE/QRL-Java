package org.qrl.stream.io.oio.seriablize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\stu.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // readObject()读取序列化文件
        Object student = ois.readObject();
        System.out.println(student);
    }
}
