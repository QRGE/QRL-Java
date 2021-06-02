package qr.Java.Annotation;

/**
 * Java 注解用于为 Java 代码提供元数据。作为元数据，注解不直接影响你的代码执行，但也有一些类型的注解实际上可以用于这一目的。
 *
 * 元注解:
 *      元注解可以理解为注解的注解, 通过这些元注解可以实现各自想要的功能,
 *      元注解有5个: @Retention、 @Target、 @Document、 @Inherited和@Repeatable
 *
 * - @Retention: 用于设置注解的保留时期
 *      - @Retention(RetentionPolicy.SOURCE): 注解仅存在于源码中，在class字节码文件中不包含
 *      - @Retention(RetentionPolicy.CLASS)， 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得
 *      - @Retention(RetentionPolicy.RUNTIME)， 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 *              - 可以通过对应的.class对象中的getAnnotation()方法获取到注解
 * - @Target: 目标, 即设置注解的作用范围
 *      * @Target(ElementType.TYPE) 作用接口、类、枚举、注解
 *      - @Target(ElementType.FIELD) 作用属性字段、枚举的常量
 *      - @Target(ElementType.METHOD) 作用方法
 *      - @Target(ElementType.PARAMETER) 作用方法参数
 *      - @Target(ElementType.CONSTRUCTOR) 作用构造函数
 *      - @Target(ElementType.LOCAL_VARIABLE)作用局部变量
 *      - @Target(ElementType.ANNOTATION_TYPE)作用于注解（@Retention注解中就使用该属性）
 *      - @Target(ElementType.PACKAGE) 作用于包
 *      - @Target(ElementType.TYPE_PARAMETER) 作用于类型泛型，即泛型方法、泛型类、泛型接口 （jdk1.8加入）
 *      - @Target(ElementType.TYPE_USE) 类型使用.可以用于标注任意类型除了 class （jdk1.8加入）
 * - @Documented: 将注解中的元素包含到 Javadoc 中去
 * - @Inherited: 被@Inherited注解了的注解修饰了一个父类，如果他的子类没有被其他注解修饰，则它的子类也继承了父类的注解
 * - @Repeatable: 被这个元注解修饰的注解可以同时作用一个对象多次，但是每次作用注解又可以代表不同的含义
 */
public class Concept {
}
