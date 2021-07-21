import qr.annotation.MyAnnotation;
import qr.annotation.entity.Book;

/**
 * @Author: QR
 * @Date: 2021/7/20-12:57
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void myAnnotationTest(){
        // 利用反射获取元注解内容
        Class<Book> bookClass = Book.class;
        boolean annotationPresent = bookClass.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent){
            MyAnnotation annotation = bookClass.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.author());
        }
    }

    public String learnTest(){
        return "Test";
    }
}
