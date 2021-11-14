package org.qrl.stream.list.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qrl.tools.util.list.ListTool;

import java.util.List;
import java.util.Optional;

/**
 * @Author QR
 * @Date 2021/10/29 10:14 PM
 */
public class OptionalDemo {

    private final static List<Integer> numList = ListTool.randomIntList(50, 100);

    /**
     * findXX() 会返回一个 Optional 容器, 代表一个值存在或不存在
     */
    @Test
    public void isPresent() {
        Optional<Integer> first = numList.stream().findFirst();
        // isPresent() 查询容器中是否有值
        Assertions.assertTrue(first.isPresent());
    }

    @Test
    public void ifPresent() {
        Optional<Integer> any = numList.stream()
                // 查看随机生成的数字是否有 60
                .filter(n -> n == 60)
                .findAny();
        // ifPresent() 传入一个 Customer 接口的实现, 如果容器有值则会执行实现方法
        any.ifPresent(n -> System.out.println("随机生成了指定数字: " + n));
    }

    @Test
    public void get() {
        Optional<Integer> any = numList.stream().findAny();
        if (any.isPresent()) {
            Integer randomNum = any.get();
            System.out.println(randomNum);
        }
    }

}
