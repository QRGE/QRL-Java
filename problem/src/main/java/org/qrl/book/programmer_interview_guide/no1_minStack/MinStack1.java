package org.qrl.book.programmer_interview_guide.no1_minStack;

import org.qrl.exception.QRException;
import java.util.Stack;

import java.util.Optional;

/**
 * @author qr
 * @date 2021/11/18 10:19 PM
 */
public class MinStack1 {

    /**
     * 正常保存数值的 stack
     */
    private final Stack<Integer> stack = new Stack<>();

    /**
     * 用来保存 min 值
     */
    private final Stack<Integer> minStack = new Stack<>();

    public Integer pop() {
        Integer popNum = stack.pop();
        if (popNum == null) {
            throw new QRException("栈为空");
        }
        if (popNum.equals(minStack.peek())){
            minStack.pop();
        }
        return popNum;
    }

    public void push(Integer num) {
        if (minStack.isEmpty()){
            minStack.push(num);
        }
        Integer peek = minStack.peek();
        if (peek >= num) {
            minStack.push(num);
        }
        stack.push(num);
    }

    /**
     * getMin() 仅用于获取最小值, 不改变原来的栈结构
     * @return min
     */
    public Integer getMin() {
        return Optional.ofNullable(minStack.peek()).orElse(null);
    }
}
