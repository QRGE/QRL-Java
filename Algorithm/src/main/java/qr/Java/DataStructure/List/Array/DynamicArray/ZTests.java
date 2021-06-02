package qr.Java.DataStructure.List.Array.DynamicArray;

import org.junit.jupiter.api.Test;

public class ZTests {

    @Test
    void trimToSizeTest(){
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(20);
        for (int i = 0; i < 30; i++) {
            dynamicArray.add(i);
            System.out.println(dynamicArray);
            System.out.println("ElementsLength: " + dynamicArray.getElementsLength());
        }

        for (int i = 0; i < 20; i++) {
            dynamicArray.remove(0);
            System.out.println(dynamicArray);
            System.out.println("ElementsLength: " + dynamicArray.getElementsLength());
        }
    }
}
