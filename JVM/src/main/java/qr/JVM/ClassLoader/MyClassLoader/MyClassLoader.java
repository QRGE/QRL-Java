package qr.JVM.ClassLoader.MyClassLoader;

import java.io.FileNotFoundException;

public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] path = getClassPath(name);
            if (path == null){
                throw new FileNotFoundException();
            } else {
                return defineClass(name, path, 0, path.length);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);
    }

    private byte[] getClassPath(String name) {
        // 从自定义路径中加载指定类的细节
        // 如果指定路径的字节码文件进行了加密, 则需要在此处解密
        return null;
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> clazz = Class.forName("One", true, myClassLoader);
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
