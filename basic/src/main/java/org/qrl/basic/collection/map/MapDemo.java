package org.qrl.basic.collection.map;

import org.junit.jupiter.api.Test;
import org.qrl.tools.entity.Operator;
import org.qrl.tools.util.list.ListTool;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * java.util.Map 的 api
 * @author qr
 * @date 2021/11/14 2:54 PM
 */
public class MapDemo {

    private final static List<Operator> OPERATOR_LIST = ListTool.recruit();

    /**
     * compute(key, BiFunction remappingFunction) 获取 key 对应的 value 值, 如果存在则进行 mapping
     */
    @Test
    public void compute(){
        Map<String, String> number2Name = OPERATOR_LIST.stream()
                .collect(groupingBy(Operator::getNumber, mapping(Operator::getCodeName, joining())));
        number2Name.compute("B003", (K, V) -> V + " 握力计.jpg");
        System.out.println(number2Name.get("B003"));
    }
}
