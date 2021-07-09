package qr.Java.dataStructure.List.DynamicList;

import org.junit.jupiter.api.Test;

/**
 * @author QR
 */
public class DynamicListTest {

    @Test
    void trimToSizeTest(){
        DynamicList<Integer> dynamicList = new DynamicList<>(20);
        System.out.println("Initial elementsLength: " + dynamicList.getElementsLength());

        int addNum = 30;
        for (int i = 0; i < addNum; i++) {
            dynamicList.add(i);
        }
        System.out.println("After add elementsLength: " + dynamicList.getElementsLength());

        int removeNum = 20;
        for (int i = 0; i < removeNum; i++) {
            dynamicList.remove(0);
        }
        System.out.println("After remove elementsLength: " + dynamicList.getElementsLength());

        dynamicList.trimToSize();
        System.out.println("After trimToSize elementsLength: " + dynamicList.getElementsLength());
    }
}
