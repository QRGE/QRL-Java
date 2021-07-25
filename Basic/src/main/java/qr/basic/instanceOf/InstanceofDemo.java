package qr.basic.instanceOf;

import qr.basic.entity.Person;
import qr.basic.entity.Student;

/**
 * a instance b 用于查看对象a是否为类,接口b的一个实例
 *      当a为类b的一个实例, 或b的子类的实例, 或a是接口b的一个实现对象时, 返回true
 * @author QR
 */
@SuppressWarnings("all")
public class InstanceofDemo {

    public static void main(String[] args) {
        // System.out.println(i instanceof Integer); a必须是一个引用
        Student student = new Student();
        System.out.println(student instanceof Person);
        Person person = new Person();
        // getClass则不会判断是否为子类
        System.out.println(student.getClass() == person.getClass());

        // 规定如果a为null则返回false
        System.out.println(null instanceof Object);
    }
}
