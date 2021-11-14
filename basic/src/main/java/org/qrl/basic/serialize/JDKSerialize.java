package org.qrl.basic.serialize;

import cn.hutool.core.io.IoUtil;

import java.io.*;

/**
 * JDK 序列化通过 ObjectInput/OutputStream 进行读取或写出
 * @Author: QR
 * @Date: 2021/9/6-22:01
 */
public class JDKSerialize {

    public static void main(String[] args) {
        User user = new User(1, "ZhangSan123", "123456", "ZhangSan");
        try {
            File file = new File("D:\\user.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            User readUser = (User) ois.readObject();
            System.out.println(readUser);
            IoUtil.close(ois);
            IoUtil.close(oos);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
