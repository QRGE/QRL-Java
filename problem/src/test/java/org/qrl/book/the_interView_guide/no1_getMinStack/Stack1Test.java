package org.qrl.book.the_interView_guide.no1_getMinStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Stack1Test {

    private static final MinStack1 stack = new MinStack1();
    static {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    void getMin() {
        stack.push(1);
        Assertions.assertEquals(stack.getMin(), 1);
    }
}