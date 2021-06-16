package qr.JVM.MethodArea;

/**
 * jdk7之前:
 *  -Xms200m -Xmx200m -XX:PermSize=300m -XX:MaxPermSize=300m -XX:+PrintGCDetails
 * jdk8之后:
 *  -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails
 */
public class StaticField {

    // 静态对象始终存放在堆里
    private static byte[] arr = new byte[1024*1024*100]; // 100M大小的byte数组

    public static void main(String[] args) {
        System.out.println(StaticField.arr);
    }
}
