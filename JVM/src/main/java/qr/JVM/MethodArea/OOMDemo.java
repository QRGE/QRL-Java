package qr.JVM.MethodArea;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 */
public class OOMDemo extends ClassLoader{

    public static void main(String[] args) {
        int j = 0;
        try {
            OOMDemo oom = new OOMDemo();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class"+i, null, "java/lang/Object", null);
                byte[] code = classWriter.toByteArray();
                // 进行类加载创建Class对象
                oom.defineClass("Class"+i, code, 0, code.length);
                j++;
            }
        } finally {
            System.out.println("Create ClassObj: " + j);
        }
    }
}
