package org.qrl.test.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.List;

/**
 * mockito 可以生成测试对象
 * @author qr
 * @date 2021/11/14 8:18 PM
 */
@SuppressWarnings("all")
public class MockitoTest {

    private final static List mockList = mock(List.class);

    @Test
    public void test1(){
        mockList.add("one");
        mockList.clear();
        // verify() 验证一些行为
        verify(mockList).add("one");
        verify(mockList).clear();
    }

    @Test
    public void test2(){
        when(mockList.get(0)).thenReturn("666");
        System.out.println(mockList.get(0));
    }
}
