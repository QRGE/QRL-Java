package qr.JVM.Stack;

public class StackError {

    private static int count = 0;

    // 不断递归自己, 栈容量不足抛出StackOverflowError
    // 通过Edit Configuration的Add VM options选项可以设置Java编译的参数, 其中-Xss为设置栈的内存大小
    public static void main(String[] args) {
        System.out.println(++count);
        main(args);
    }


}
