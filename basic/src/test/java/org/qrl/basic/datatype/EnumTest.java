package org.qrl.basic.datatype;

import org.junit.jupiter.api.Test;

/**
 * @Author: QR
 * @Date: 2021/9/1-16:19
 */
public class EnumTest {

    @Test
    public void recordTest() {
        Record sugar = Record.SUGAR;
        System.out.println(Record.valueOf(sugar.getType()));
        // record 的 values 可以获取 enum 中所有的值, 其中 value 为各个值的字面量
        for (Record value : Record.values()) {
            System.out.println(value);
        }
    }
}
