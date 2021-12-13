package org.qrl.book.programmer_interview_guide.no4_catDogQueue;

import org.junit.Test;
import org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity.Pet;

/**
 * @author qr
 * @date 2021/12/13 23:56
 */
public class CatDogQueueTest {

    @Test
    public void catDogQueueTest() {
        CatDogQueue queue = new CatDogQueue();
        queue.add(new Pet("cat"));
        queue.add(new Pet("cat"));
        queue.add(new Pet("cat"));
        queue.add(new Pet("cat"));
        queue.add(new Pet("dog"));
        queue.add(new Pet("dog"));
        queue.add(new Pet("dog"));
        queue.add(new Pet("dog"));
        System.out.println(queue.pullDog());
        System.out.println(queue.pullDog());
        System.out.println(queue.pullDog());
        System.out.println(queue.pullDog());
        System.out.println(queue.pullAll());
    }
}
