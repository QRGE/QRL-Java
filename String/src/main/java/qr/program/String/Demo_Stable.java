package qr.program.String;

import lombok.ToString;

import java.util.Arrays;

/**
 * @Author qr
 * @Date 2022/5/11-21:25
 */
public class Demo_Stable {

    public final char[] value;

    public Demo_Stable(char[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    public static void main(String[] args) {
        char[] chars = new char[3];
        chars[0] = 'a';
        Demo_Stable demo1Stable = new Demo_Stable(chars);
        System.out.println(demo1Stable);
        chars[1] = 'b';
        System.out.println(demo1Stable);
        chars[2] = 'c';
        System.out.println(demo1Stable);
    }
}
