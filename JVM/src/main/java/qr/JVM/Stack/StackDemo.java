package qr.JVM.Stack;

/**
 * 虚拟机栈是由一个个栈帧构成, 每个栈帧对应着一个调用方法
 */
public class StackDemo {

    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        // 先有一个main方法的栈帧, 调用methodA()后又创建一个methodA()的栈帧, methodA()中又调用了methodB()的方法即又创建了method()B的栈帧
        stackDemo.methodA();
    }

    public void methodA(){
        int i = 10;
        int j = 20;
        methodB();
    }

    public void methodB(){
        int k = 30;
        int m = 40;
    }
}
