package qr.JVM.Stack.StackFrame.DynamicLinking;

public class DynamicLinkingDemo {

    int money = 99;

    public void methodA(){
        System.out.println("MethodA start...");
    }

    public void methodB(){
        methodA();
        System.out.println("MethodB start...");
        money++;
    }


}
