package qr.Java.dataStructure.ZPractice.List.Stack;


import java.util.Stack;

/**
 * 用栈实现浏览器的向前和向后
 * @author QR
 */
public class FrontAndBack {

    private final Stack<String> views = new Stack<>();
    private final Stack<String> temp = new Stack<>();

    /**
     * 每次浏览的网页连接都存入views中
     * @param website 浏览的网页
     */
    public void visit(String website){
        views.push(website);
        System.out.println("Visiting: " + website);
        if (!temp.isEmpty()){
            temp.removeAllElements();
        }
    }

    /**
     * 将 views 中第一个元素出栈, 由于views中元素的入栈顺序是按照访问顺序入栈的, 出栈后栈顶即为上一次访问的网页
     * 存入temp则用于front
     */
    public void back(){
        temp.push(views.pop());
        System.out.println(views.peek());
    }

    public void front(){
        if (temp.isEmpty()){
            System.out.println("null");
            return;
        }
        String front = temp.pop();
        System.out.println(front);
        views.push(front);
    }

    public static void main(String[] args) {
        FrontAndBack frontAndBack = new FrontAndBack();
        frontAndBack.visit("Baidu");
        frontAndBack.visit("JD");
        frontAndBack.visit("Ali");
        frontAndBack.back();
        frontAndBack.back();
        frontAndBack.front();
        frontAndBack.front();
        frontAndBack.back();
        frontAndBack.back();
        frontAndBack.visit("BiliBili");
        frontAndBack.front();
    }
}
