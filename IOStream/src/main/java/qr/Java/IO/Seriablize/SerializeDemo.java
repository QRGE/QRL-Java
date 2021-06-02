package qr.Java.IO.Seriablize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 待序列化对象的类必须实现Serialize接口
 * 序列化中的成员变量如果是一个类A, 那么A也需要实现Serialize接口
 * 需要添加一个成员变量serializeVersionID: 序列化版本化ID, 可用于保证序列化的类和反序列化的类是同一个类
 *      如果没有添加则会默认生成一个serializeVersionID, 此时如果改变原来序列化的类svID, 则会因为ID不同报错: InvalidClassException
 * 使用transient(暂时的, 瞬时的)修饰一个成员变量, 那么这个成员变量不会被序列化
 * 静态属性是不能被序列化的
 * 如果需要同时序列化多个对象, 可以把多个对象放进一个集合类型中, 例如ArrayList
 */
public class SerializeDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\stu.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student = new Student(1, "Automation184","QR");
        // 待序列化对象的类需要实现Serializable
        oos.writeObject(student);
        oos.close();
        System.out.println("Serialized Done");
    }
}
