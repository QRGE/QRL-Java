package qr.data.structure.map;

import org.junit.jupiter.api.Test;

/**
 * @Author: QR
 * @Date: 2021/7/19-22:22
 */
public class TreeMapTests {

    @Test
    public void mapTest(){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "一");
        treeMap.put(2, "二");
        treeMap.put(3, "三");
        treeMap.put(4, "四");
        treeMap.traversal(new Map.Visitor<Integer, String>() {
            @Override
            boolean visit(Integer key, String value) {
                System.out.println(key + ":" + value);
                return true;
            }
        });
    }
}
