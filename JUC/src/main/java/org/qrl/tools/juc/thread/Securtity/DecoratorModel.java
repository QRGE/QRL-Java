package org.qrl.tools.juc.thread.Securtity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class DecoratorModel {

    private static final List<Integer> list = new ArrayList<>(10000);
    private static final List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>(10000));

    public static void main(String[] args) throws InterruptedException {
        list.add(0);
        for (int i = 1; i <= 9999; i++) {
            int finalI = i;
            new Thread(()-> list.add(finalI)).start();
        }

        synchronizedList.add(0);
        for (int i = 1; i <= 9999; i++) {
            int finalI = i;
            new Thread(()-> synchronizedList.add(finalI)).start();
        }

        Thread.sleep(5000);
        System.out.println(list);
        System.out.println(synchronizedList);
    }
}
