package qr.JVM.Heap;

import qr.basic.util.thread.ThreadTool;

/**
 * 在Edit Configuration中 add VMOption 可以设置通过-Xms和-Xmx设置堆的初始内存和最大内存
 */
public class HeapInitial {

    public static void main(String[] args) {
        // 获取堆的初始内存大小和最大内存大小, 默认单位为B, /1024/1024获得MB值
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        // 堆中有一个eden区和两个survivor区, 存放对象时只能存放在一个survivor区中, 所以下值显示总会比设定值少一点
        // jps 查看各进程参数 / jstat -gc ThreadId 可以查看具体情况
        // 也可以添加运行时参数-XX:PrintGCDetails 查看内存信息
        System.out.println("-Xms : " + initialMemory + "M");
        System.out.println("-Xmx : " + maxMemory + "M");

        ThreadTool.sleepS(1000);
    }
}
