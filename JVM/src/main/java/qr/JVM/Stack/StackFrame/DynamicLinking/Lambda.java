package qr.JVM.Stack.StackFrame.DynamicLinking;

/**
 * invokedynamic指令
 */
@FunctionalInterface
interface Func {
    boolean func(String str);
}

public class Lambda {
    public void lambda(Func func) {
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        // invokedynamic
        Func func = s -> true;

        lambda.lambda(func);

        lambda.lambda(s -> true);
    }
}

