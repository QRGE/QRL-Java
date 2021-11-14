package org.qrl.basic.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Character类API
 * - boolean isJavaIdentifierPart(char ch): 判断某个字符是否为标识符
 * @Author: QR
 * @Date: 2021/7/12-18:56
 */
public class Main {

    @Test
    public void part(){
        Assertions.assertFalse(Character.isJavaIdentifierPart('&'));
        Assertions.assertTrue(Character.isJavaIdentifierPart('_'));
    }

    @Test
    public void start(){
        Assertions.assertFalse(Character.isJavaIdentifierStart('&'));
        Assertions.assertTrue(Character.isJavaIdentifierStart('_'));
        // $ 也可以是 Java 类的开头
        Assertions.assertTrue(Character.isJavaIdentifierStart('$'));
    }
}
