package org.qrl.leetcode.no155_minStack;

import java.util.*;

/**
 * 由于总是在非空栈上 get 就不设置校验了
 */
class MinStack {

    /**
     * 用于存储最所有的数据
     */
    private final Stack<Integer> stack;
    /**
     * 每次传入时只存储 当前栈数据+新增数据 中的最小值
     */
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

