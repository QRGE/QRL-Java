package qr.Java.DataStructure.List.LinkedList;

import org.junit.jupiter.api.Test;

public class AllTests {

    @Test
    void DoubleLinkedListTest(){
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(0, 23);
        linkedList.add(1, 44);
        linkedList.add(2, 97);
        linkedList.set(2, 233);
        linkedList.remove(2);
        linkedList.add(666);
        linkedList.add(976);
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf(44));
    }

    @Test
    void SinglyCircularLinkListTest(){
        SinglyCircularLinkedList<Integer> linkedList = new SinglyCircularLinkedList<>();
        linkedList.add(0, 23);
        linkedList.add(1, 44);
        linkedList.add(2, 97);
        linkedList.set(2, 233);
        linkedList.remove(2);
        linkedList.add(666);
        linkedList.add(976);
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf(44));
    }

    @Test
    void DoubleCircularLinkedListTest(){
        DoubleCircularLinkedList<Integer> linkedList = new DoubleCircularLinkedList<>();
        linkedList.add(0, 23);
        linkedList.add(1, 44);
        linkedList.add(2, 97);
        linkedList.set(2, 233);
        linkedList.remove(2);
        linkedList.add(666);
        linkedList.add(976);
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf(44));
    }
}
