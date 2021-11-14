package org.qrl.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

/**
 * mockito 可以生成测试对象
 * @author qr
 * @date 2021/11/14 8:18 PM
 */
@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    private List<Integer> numList;

    @Test
    public void test1(){
        numList.add(1);
        // ?
        Assertions.assertEquals(0, numList.size());
    }
}
