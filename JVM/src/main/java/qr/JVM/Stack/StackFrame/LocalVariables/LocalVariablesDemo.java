package qr.JVM.Stack.StackFrame.LocalVariables;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalVariablesDemo {

    public static void main(String[] args) {
        LocalVariablesDemo localVariablesDemo = new LocalVariablesDemo();
        localVariablesDemo.method1();
        int num = 20;
    }

    public void method1(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String now = sdf.format(date);
        String name = "QR";
        System.out.println("Now: " + now + " Author: " + name);
    }
}
