package org.qrl.leetcode.no155_minStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    private final static MinStack stack = new MinStack();
    static {
        stack.push(-2);
        stack.push(0);
        stack.push(-1);
    }

    @Test
    void pop() {
    }

    @Test
    void top() {
    }

    @Test
    void getMin() {
        System.out.println(stack.getMin());
    }
}