package qr.JVM.MethodArea;

import java.io.Serializable;

/**
 * 方法区保存着类型信息(包括类, 域, 方法的信息)
 * 通过javap反编译字节码可以查看其内容
 */
public class MethodAreaStruct implements Comparable<String>, Serializable {

    //Field
    public int num = 10;
    private static final String str = "MethodAreaStruct";

    //constructor

    //methods
    public void method1(){
        int count = 20;
        System.out.println("count = " + count);
    }
    public static int method2(int cal){
        int result = 0;
        try {
            int value = 30;
            result = value / cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
