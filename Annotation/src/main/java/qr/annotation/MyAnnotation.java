package qr.annotation;

import java.lang.annotation.*;

/**
 * @author QR
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
    String author() default "QR";
}
