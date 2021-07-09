package qr.Java.dataStructure.ZPractice;


import java.util.Stack;

public class FrontAndBack {

    private final Stack<String> views = new Stack<>();
    private final Stack<String> temp = new Stack<>();

    public void visit(String website){
        views.push(website);
        System.out.println("Visiting: " + website);
        if (!temp.isEmpty()){
            temp.removeAllElements();
        }
    }

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
