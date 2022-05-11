package qr.program.String;

/**
 * intern()：如果字符串常量池中已经包含（equals）某个字符串常量则直接返回常量池中的引用，否则创建新的字符串再返回引用
 * @Author qr
 * @Date 2022/5/9-10:32
 */
public class StringIntern {

    public static void main(String[] args) {
        String java = "java";
        String java2 = java.intern();
        System.out.println(java2);
    }
}
