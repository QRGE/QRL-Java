package qr.JVM.Optimize;

import qr.basic.util.thread.ThreadTool;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * 可以通过开启或关闭栈上分配进行内存对比
 * */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            alloc(i); // 对象未发生逃逸
        }
        long end = System.currentTimeMillis();
        // 通过分析可以得到通过栈上分配的事件仅为8ms, 而未开启栈上分配需要12121ms, 主要是省略和很多GC时间, 栈不会发生GC
        System.out.println("Speed Time: " + (end - start));

        // 暂停用于查看内存情况
        ThreadTool.sleepS(300);
    }

    private static void alloc(Integer id) {
        User user = new User(id);
    }
}

class User{

    Integer id;

    public User(Integer id){
        this.id = id;
    }
}
