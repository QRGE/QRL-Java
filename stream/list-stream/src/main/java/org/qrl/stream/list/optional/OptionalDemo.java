package org.qrl.stream.list.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qrl.util.mock.MockDataTool;

import java.util.List;
import java.util.Optional;

/**
 * @Author QR
 * @Date 2021/10/29 10:14 PM
 */
public class OptionalDemo {

    private final static List<Integer> numList = MockDataTool.randomIntegerNumList(20, 100);

    /**
     * findXX() 会返回一个 Optional 容器, 代表一个值存在或不存在
     */
    @Test
    public void isPresentTest() {
        Optional<Integer> first = numList.stream().findFirst();
        // isPresent() 查询容器中是否有值
        Assertions.assertTrue(first.isPresent());
    }

    @Test
    public void ifPresentTest() {
        Optional<Integer> any = numList.stream().findAny();
        // ifPresent() 传入一个 Customer 接口的实现, 如果容器有值则会执行实现方法
        any.ifPresent(System.out::println);
    }

    @Test
    public void getTest() {
        Optional<Integer> any = numList.stream().findAny();
        if (any.isPresent()) {
            Integer randomNum = any.get();
            System.out.println(randomNum);
        }
    }

}
