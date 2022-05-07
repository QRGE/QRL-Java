package org.qrl.basic.obj;

import lombok.SneakyThrows;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 创建对象的4种方式：
 * new
 * 序列化, Serializable 例如 objectInput/OutputStream json
 * clone  Cloneable
 * 反射 Class.forName().xx
 * @Author qr
 * @Date 2022/5/7-10:33
 */
public class Main {

    @SneakyThrows
    public static void main(String[] args) throws ClassNotFoundException {
        Operator amiya = new Operator(1, "Amiya");
        System.out.println(amiya);
        Constructor<?>[] constructors = Class.forName("org.qrl.basic.obj.Operator").getConstructors();
        Arrays.stream(constructors).findFirst().ifPresent(c -> {
            Object operator2 = null;
            try {
                operator2 = c.newInstance(2, "Kal'tsit");
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(operator2);
        });
        Operator operator3 = amiya.clone();
        System.out.println(operator3);
        String path = "/Users/qr/note/operator3.ser";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(amiya);
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object operator4 = objectInputStream.readObject();
        System.out.println(operator4);
    }
}
