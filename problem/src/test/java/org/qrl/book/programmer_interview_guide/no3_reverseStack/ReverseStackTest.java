package org.qrl.book.programmer_interview_guide.no3_reverseStack;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * @author qr
 * @date 2021/12/13 21:39
 */
public class ReverseStackTest {

    @Test
    public void reverseStackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        ReverseStack.reverse(stack);
        Assertions.assertEquals(stack.peek(), 1);
    }
}
