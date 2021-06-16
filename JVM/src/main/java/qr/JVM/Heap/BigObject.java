package qr.JVM.Heap;

public class BigObject {

    public static void main(String[] args) {
        // -Xms60m -Xmx60m -XX:NewRation=2 -XX:SurvivorRation=8 -XX:+PrintGCDetails
        byte[] nums = new byte[1024 * 1024 * 20]; // 20m的数组

        // 运行有可以看到老年代的内存空间被占用了20m
    }
}
