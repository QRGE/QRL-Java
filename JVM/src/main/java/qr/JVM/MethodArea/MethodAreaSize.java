package qr.JVM.MethodArea;

import qr.Java.Utils.Thread.TSTools;

/**
 * jdk7以前通过-XX:PermSize=XX 和 -XX:MaxPermSize=XX 设置方法区的初始值和最大值
 * jdk8以后通过-XX:MetaspaceSize=XX 和 -XX:MaxMetaspaceSize=XX 设置方法区的初始值和最大值
 * -XX:MetaspaceSize=100M -XX:MaxMetaspaceSizeXX=100M
 */
public class MethodAreaSize {
    public static void main(String[] args) {
        System.out.println("start...");
        // 休眠1000S去验证设置的元空间大小是否生效
        // jps查看执行当前方法的线程编号
        // jinfo -flag MetaspaceSize ThreadId查看指定参数信息
        TSTools.sleepS(1000);
        System.out.println("End");
    }
}
