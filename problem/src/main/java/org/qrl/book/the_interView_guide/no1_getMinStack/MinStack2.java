package org.qrl.book.the_interView_guide.no1_getMinStack;

import org.qrl.exception.QRException;

import java.util.Stack;

/**
 * @author qr
 * @date 2021/11/19 9:41 AM
 */
public class MinStack2 {

    private final Stack<Integer> stack = new Stack<>();

    private final Stack<Integer> stackMin = new Stack<>();

    public Integer pop(){
        if (stack.isEmpty()){
            throw new QRException("栈为空");
        }
        stackMin.pop();
        return stack.pop();
    }

    /**
     * push 时每次都存入最小值
     * @param num push 的值
     */
    public void push(Integer num) {
        Integer peek = stackMin.peek();
        if (peek == null) {
            stack.push(num);
        }else if (num < peek){
            stackMin.push(num);
        }else {
            stackMin.push(peek);
        }
        stack.push(num);
    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            throw new QRException("栈为空");
        }
        return stackMin.pop();
    }
}
