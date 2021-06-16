package qr.JVM.Stack.StackFrame.DynamicLinking;

/**
 * invokestatic：调用静态方法，解析阶段确定唯一方法版本(调用非虚方法)
 * invokespecial：调用构造器方法，私有方法以及父类方法，解析阶段确定唯一方法版本(同上)
 * invokevirtual：调用所有虚方法(但不全是虚方法,有些方法用final修饰)
 * invokeinterface：调用接口方法
 * invokedynamic：动态解析出需要调用的方法，然后执行(动态调用指令)
 */
class Father {
    public Father() {
        System.out.println("father's constructor");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final method");
    }

    public void showCommon() {
        System.out.println("father show common method");
    }
}

public class Son extends Father {
    public Son() {
        //invokespecial
        super();
    }
    public Son(int age) {
        //invokespecial
        this();
    }
    //不是重写的父类的静态方法，因为静态方法不能被重写！
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }
    private void showPrivate(String str) {
        System.out.println("son " + str);
    }

    public void show() {
        //invokestatic
        showStatic("static");
        //invokestatic
        Father.showStatic("good!");

        //invokespecial
        showPrivate("hello!");
        //invokespecial
        super.showCommon();

        //invokevirtual
        showFinal();    // 因为此方法声明有final，不能被子类重写，所以也认为此方法是非虚方法。
        //invokevirtual
        showCommon();   // 调用虚方法
        info();

        // invokedynamic: 利用lambda传入实现方法
        MethodInterface in = () -> System.out.println("Interface's method");
        //invokeinterface
        in.methodA();
    }

    public void info(){

    }

    public void display(Father f){
        f.showCommon();
    }

    public static void main(String[] args) {
        Son so = new Son();
        so.show();
    }
}

@FunctionalInterface
interface MethodInterface{
    void methodA();
}
