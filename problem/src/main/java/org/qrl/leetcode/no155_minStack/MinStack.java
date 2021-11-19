package org.qrl.leetcode.no155_minStack;

import java.util.*;

/**
 * 由于总是在非空栈上 get 就不设置校验了
 */
class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int val) {
        // stackMin 每次 push 总是保存最小值
        if(stackMin.isEmpty()) {
            stackMin.push(val);
        }else if(val < stackMin.peek()) {
            stackMin.push(val);
        }else {
            stackMin.push(stackMin.peek());
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

