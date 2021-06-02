package qr.Java.DataStructure.List.Array.DynamicArray;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(9);
        numbers.add(7);
        // trimToSize()可以把ArrayList存放元素的数组的容量改变成size,
        numbers.trimToSize();
        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.println(numbers.get(1));
    }
}
