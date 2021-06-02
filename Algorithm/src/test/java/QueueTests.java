import org.junit.jupiter.api.Test;
import qr.Java.DataStructure.List.Queue.CircleDeque;
import qr.Java.DataStructure.List.Queue.CircleQueue;
import qr.Java.DataStructure.List.Queue.Deque;
import qr.Java.DataStructure.List.Queue.Queue;

public class QueueTests {

    @Test
    void QueueTest(){
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(37);
        queue.enQueue(42);
        queue.enQueue(98);
        queue.enQueue(16);
        queue.enQueue(25);
        while (!queue.isEmpty()){
            // FIFO, 和输出元素的顺序和加入元素的顺序一致
            System.out.println(queue.deQueue());
        }
    }

    @Test
    void DequeTest(){
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(21); // 3
        deque.enQueueFront(34); // 2
        deque.enQueueFront(73); // 1
        deque.enQueueRear(97);  // 4
        deque.enQueueRear(99);  // 5
        while (!deque.isEmpty()){
            // FIFO, 和输出元素的顺序和加入元素的顺序一致
            System.out.println(deque.deQueueFront());
        }
    }

    @Test
    void CircleTest(){
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 1; i <= 10; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        for (int i = 0; i < 5; i++) {
            circleQueue.deQueue();
        }
        System.out.println(circleQueue);
        for (int i = 15; i < 20; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        for (int i = 20; i < 30; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);

        // 按照 头 → 尾 的顺序展现队列内的所有元素
        int size = circleQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(circleQueue.deQueue() + " ");
        }
    }

    @Test
    public void CircleDeque(){
        CircleDeque<Integer> circleDeque = new CircleDeque<>();
        for (int i = 0; i < 5; i++) {
            circleDeque.enQueueFront(i);
        }
        System.out.println(circleDeque);
        for (int i = 5; i < 10; i++) {
            circleDeque.enQueueRear(i);
        }
        System.out.println(circleDeque);
        for (int i = 0; i < 5; i++) {
            circleDeque.deQueueRear();
        }
        System.out.println(circleDeque);
    }
}
