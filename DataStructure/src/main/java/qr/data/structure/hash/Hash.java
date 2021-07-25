package qr.data.structure.hash;

import org.junit.jupiter.api.Test;

/**
 * @Author: QR
 * @Date: 2021/7/20-21:01
 */
@SuppressWarnings("all")
public class Hash {

    public static int HashValue(float f){
        return Float.floatToIntBits(f);
    }

    public static int HashValue(String s){
        int len = s.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 等同于 hashCode * 31
            hashCode = (hashCode << 5) - hashCode + c;
        }
        return hashCode;
    }

    @Test
    public void objHashCode(){
        Person p1 = new Person(21, 177.7f, "ToolMan", new Car(1, "BMW"));
        Person p2 = new Person(22, 177.7f, "ToolMan", new Car(2, "Benz"));
        // Object 的 hashCode() 和内存对象挂钩
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
