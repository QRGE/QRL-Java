package qr.basic.annotation;

/**
 * @author QR
 */
public class Test {
    public static void main(String[] args) {
        // 利用反射获取元注解内容
        Class<Book> bookClass = Book.class;
        boolean annotationPresent = bookClass.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent){
            MyAnnotation annotation = bookClass.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.author());
        }
    }
}
