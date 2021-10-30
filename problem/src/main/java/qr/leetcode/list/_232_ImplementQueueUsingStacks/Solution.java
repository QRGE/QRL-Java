package qr.leetcode.list._232_ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/submissions/
 */
@SuppressWarnings("all")
public class Solution {

    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public Solution() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void checkOutStack(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
