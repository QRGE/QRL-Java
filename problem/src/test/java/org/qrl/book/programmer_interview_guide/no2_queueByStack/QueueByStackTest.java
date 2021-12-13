package org.qrl.book.programmer_interview_guide.no2_queueByStack;

import org.junit.jupiter.api.Assertions;

/**
 * @author qr
 * @date 2021/12/13 21:00
 */
public class QueueByStackTest {

    @org.junit.Test
    public void queueByStack() {
        QueueByStack queue = new QueueByStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        Assertions.assertEquals(queue.peek(), 1);
        queue.add(4);
        Assertions.assertEquals(queue.poll(), 1);
        Assertions.assertEquals(queue.poll(), 2);
        Assertions.assertEquals(queue.poll(), 3);
        Assertions.assertEquals(queue.poll(), 4);
    }
}
