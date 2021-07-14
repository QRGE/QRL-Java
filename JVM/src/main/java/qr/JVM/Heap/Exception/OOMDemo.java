package qr.JVM.Heap.Exception;

import qr.basic.util.thread.ThreadTool;

import java.util.ArrayList;

/**
 * 测试一下堆的OOM, 可以用过jVisualVM查看内存的具体情况, 如果没有Visual GC选项, 可以从插件处下载
 *
 */
public class OOMDemo {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // 通过不断创建新的对象撑爆堆内存, 当Old区不能存放新的对象时, 就会产生OOM异常
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ThreadTool.sleepMs(1);
            students.add(new Student(i));
        }
        System.out.println(students);
    }
}

class Student{

    Integer id;

    public Student(Integer id){
        this.id = id;
    }
}
