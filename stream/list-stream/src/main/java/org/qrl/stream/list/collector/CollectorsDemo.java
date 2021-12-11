package org.qrl.stream.list.collector;

import org.junit.jupiter.api.Test;
import org.qrl.tools.entity.Operator;
import org.qrl.tools.util.list.ListTool;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


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
    public void toCollectionDemo(){
        LinkedHashSet<Integer> numSet = numList.stream()
                .filter(n -> n > 1000)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (Integer integer : numSet) {
            System.out.println(integer);
        }
    }

    /**
     * groupingBy() 可以根据你指定的字段(k)对流进行分组生成一个 k : 分组对象List
     */
    @Test
    public void groupingByDemo(){
        Map<Integer, Long> map = OPERATOR_LIST.stream()
                .collect(Collectors.groupingBy(Operator::getGender, Collectors.counting()));
        // 统计这次招募的男女干员的比例 (目前还是写死的数据)
        map.forEach((k, v) -> System.out.println("Gender: " + k + ", count: " + v));
    }

    /**
     * 通过 groupingBy() 获得一个 id : name 的映射
     */
    @Test
    public void idToName() {
        Map<String, String> idToName = OPERATOR_LIST.stream()
                .collect(groupingBy(Operator::getNumber, mapping(Operator::getCodeName, joining())));
        idToName.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    /**
     * Collectors.mapping() 可以将分组的 list 进行类似 map() 的操作
     */
    @Test
    public void mappingDemo(){
        Map<Integer, String> map = OPERATOR_LIST.stream()
                .collect(groupingBy(Operator::getGender, mapping(Operator::getCodeName, joining(", "))));
        map.forEach((k, v) -> System.out.printf("gender: %d, CodeNames: %s\n", k, v));
    }
}
