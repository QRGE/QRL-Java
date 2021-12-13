package org.qrl.book.programmer_interview_guide.no2_queueByStack;

import java.util.Stack;

import java.util.Objects;

/**
 * 再简单的东西自己不理解也没用😁，加油干
 * 用两个栈实现一个队列
 * 每次 poll 的时候都先把 push 里的内容给全部压入 stackPop 中，可以保证顺序相反
 * @author qr
 * @date 2021/12/13 20:22
 */
@SuppressWarnings("unused")
public class QueueByStack {

    private final Stack<Integer> stackPush = new Stack<>();

    private final Stack<Integer> stackPop = new Stack<>();

    public void add(Integer num) {
        stackPush.push(num);
    }

    public Integer poll() {
        pushToPop();
        return stackPop.pop();
    }

    public Integer peek() {
        pushToPop();
        return stackPop.peek();
    }

    public boolean empty(){
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    public void pushToPop(){
        // pop 不为空的时候才把 push 全部导入 pop
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
}
