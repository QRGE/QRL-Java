package org.qrl.book.programmer_interview_guide.no3_reverseStack;

import java.util.Stack;

/**
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的*逆序，但是只能用递归函数来实现，不能用其他数据结构
 * @author qr
 * @date 2021/12/13 21:23
 */
public class ReverseStack {

    private static int popLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = popLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = popLastElement(stack);
        reverse(stack);
        stack.push(result);
    }
}
