package org.qrl.stream.list;

import org.junit.jupiter.api.Test;
import org.qrl.stream.list.entity.Apple;
import org.qrl.tools.util.list.ListTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {

    private static final List<Apple> appleList = new ArrayList<>(10);
    static {
        appleList.add(new Apple(1, 1.0, "青苹果"));
        appleList.add(new Apple(2, 1.5, "红苹果"));
        appleList.add(new Apple(3, 2.0, "红富士"));
        appleList.add(new Apple(4, 2.5, "烂苹果"));
        appleList.add(new Apple(5, 3.0, "黑苹果"));
        appleList.add(new Apple(5, 3.0, "黑苹果"));
    }

    public static final List<Integer> numList = ListTool.randomIntList(30, 666);

    @Test
    public void countTest() {
        // stream() 用于生成一个流对象
        long count = appleList.stream()
                // filer 是一个中间操作, 返回的是一个 Stream 对象
                .filter(apple -> apple.getWeight() > 2)
                // count 是一个终端操作, 返回的不是 Stream 对象, 此处 count 返回出计算值
                .count();
        System.out.println(count);
    }

    @Test
    public void distinctTest() {
        List<Apple> newAppleList = appleList.stream()
                // distinct() 可以用于去重, 如果是对象类型的数据记得重写 equals()
                .distinct()
                .collect(Collectors.toList());
        newAppleList.forEach(System.out::println);
    }

    @Test
    public void skipTest() {
        List<Integer> newNumList = numList.stream()
                // skip() 可以用于跳过指定个数元素
                .skip(20)
                .filter(num -> num < 40)
                .collect(Collectors.toList());
        newNumList.forEach(System.out::println);
    }

    @Test
    public void reduceTest() {
        // 求一个数字列表之和
        Integer sum = numList.stream().reduce(0, Integer::sum);
        System.out.println("sum: " + sum);
        // 乘积
        Integer product = numList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product: " + product);
        // 没有初始值的 reduce() 会返回一个 Optional 防止流为空的情况
        Optional<Integer> optional = numList.stream().reduce((a, b) -> a * a + b * b);
        Integer sumOfSquares = null;
        if (optional.isPresent()) {
            sumOfSquares = optional.get();
        }
        System.out.println("Sum of squares: " + sumOfSquares);
        // 最小
        Integer min = numList.stream().reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("min: " + min);
    }
}
