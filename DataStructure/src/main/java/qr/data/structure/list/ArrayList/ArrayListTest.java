package qr.data.structure.list.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author QR
 */
public class ArrayListTest {

    @Test
    void trimToSizeTest(){
        ArrayList<Integer> arrayList = new ArrayList<>(20);
        System.out.println("Initial elementsLength: " + arrayList.getElementsLength());

        int addNum = 30;
        for (int i = 0; i < addNum; i++) {
            arrayList.add(i);
        }
        System.out.println("After add elementsLength: " + arrayList.getElementsLength());

        int removeNum = 20;
        for (int i = 0; i < removeNum; i++) {
            arrayList.remove(0);
        }
        System.out.println("After remove elementsLength: " + arrayList.getElementsLength());

        arrayList.trimToSize();
        System.out.println("After trimToSize elementsLength: " + arrayList.getElementsLength());
    }
}
