package org.qrl.stream.list.collector;

import org.junit.jupiter.api.Test;
import org.qrl.tools.entity.Operator;
import org.qrl.tools.util.list.ListTool;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 有关 Collectors 的 api
 * @author qr
 * @date 2021/11/13 5:00 PM
 */
public class CollectorsDemo {

    private final static List<Integer> numList = ListTool.randomIntList(100,10000);

    private final static List<Operator> OPERATOR_LIST = ListTool.recruit();

    /**
     * toCollection() 方法可以指定生成对应类型的 Collection 类
     */
    @Test
    public void toCollection(){
        LinkedHashSet<Integer> numSet = numList.stream()
                .filter(n -> n > 1000)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (Integer integer : numSet) {
            System.out.println(integer);
        }
    }
}
