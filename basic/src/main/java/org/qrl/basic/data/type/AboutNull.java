package org.qrl.basic.data.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author: QR
 * @Date: 2021/7/20-13:52
 */
public class AboutNull {

    /**
     * java 中 null == null
     */
    @Test
    public void nullTest(){
        String a = null;
        String b = null;
        Assertions.assertEquals(a, b);
    }
}
