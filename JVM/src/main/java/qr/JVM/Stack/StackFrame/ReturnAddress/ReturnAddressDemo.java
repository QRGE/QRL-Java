package qr.JVM.Stack.StackFrame.ReturnAddress;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * 返回指令包含ireturn（当返回值是boolean、byte、char、short和int类型时使用）、
 * lreturn、freturn、dreturn以及areturn，另外还有一个return指令供声明为void的方法、
 * 实例初始化方法、类和接口的初始化方法使用。
 */
public class ReturnAddressDemo {
    // ireturn
    public boolean methodBoolean() {
        return false;
    }

    // ireturn
    public byte methodByte() {
        return 0;
    }

    // ireturn
    public short methodShort() {
        return 0;
    }

    // ireturn
    public char methodChar() {
        return 'a';
    }

    // ireturn
    public int methodInt() {
        return 0;
    }

    // lreturn
    public long methodLong() {
        return 0L;
    }

    // freturn
    public float methodFloat() {
        return 0.0f;
    }

    // dreturn
    public double methodDouble() {
        return 0.0;
    }

    // areturn
    public String methodString() {
        return "areturn";
    }

    // areturn
    public Date methodDate() {
        return null;
    }

    // return
    public void methodVoid() {

    }

    // clinit中可以看到是return
    static {
        int i = 10;
    }


    //
    public void method2() {
        methodVoid();

        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        FileReader fis = new FileReader("Data.txt");
        char[] cBuffer = new char[1024];
        int len;
        while ((len = fis.read(cBuffer)) != -1) {
            String str = new String(cBuffer, 0, len);
            System.out.println(str);
        }
        fis.close();
    }
}
