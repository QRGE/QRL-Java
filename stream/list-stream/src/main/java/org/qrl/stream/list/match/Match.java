package org.qrl.stream.list.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * xxMatch() 也是终端操作, 会返回一个非流结果
 * xxMatch() 和 limit() 都是短路操作: 并不需要完整遍历流
 * @Author QR
 * @Date 2021/10/29 12:00 AM
 */
public class Match {

    private static final List<Integer> nums = Arrays.asList(1,2,3,5,6,12,44,52,77);

    @Test
    public void anyMatch(){
        // 部分匹配
        Assertions.assertTrue(nums.stream().anyMatch(n->n > 10));
    }

    @Test
    public void allMatch(){
        // 全部匹配
        Assertions.assertFalse(nums.stream().allMatch(n->n > 10));
    }

    @Test
    public void noneMatch(){
        // 没有一个匹配
        Assertions.assertFalse(nums.stream().noneMatch(n -> n.equals(77)));
    }

    @Test
    public void findAny(){
        Optional<Integer> findNums = nums.stream()
                .filter(n -> n > 50)
                // findXX() 返回的是Optional类, Optional是一个容器, 代表一个值存在或不存在
                // findAny() 找到任意一个元素
                .findAny();
        if (findNums.isPresent()) {
            Integer integer = findNums.get();
            System.out.println(integer);
        }
    }
}
