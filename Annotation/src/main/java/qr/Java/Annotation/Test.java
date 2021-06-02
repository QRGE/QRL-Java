package qr.Java.Annotation;

public class Test {
    public static void main(String[] args) {
        // 利用反射获取元注解内容
        Class<Book> aClass = Book.class;
        boolean annotationPresent = aClass.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent){
            MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.author());
        }
    }
}
