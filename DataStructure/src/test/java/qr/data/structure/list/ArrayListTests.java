package qr.data.structure.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Author: QR
 * @Date: 2021/7/4-14:57
 */
public class ArrayListTests {

    @Test
    public void ArrayListTest(){
        ArrayList<Integer> nums = new ArrayList<>(20);
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        System.out.println(nums);
    }
}
